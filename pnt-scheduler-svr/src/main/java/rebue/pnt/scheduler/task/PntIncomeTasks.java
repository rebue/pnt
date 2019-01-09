package rebue.pnt.scheduler.task;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import rebue.pnt.svr.feign.PntIncomeSvc;

/**
 * 积分收益任务
 * 
 * @author lbl
 */
@Component
public class PntIncomeTasks {

	private final static Logger _log = LoggerFactory.getLogger(PntIncomeTasks.class);

	@Resource
	private PntIncomeSvc pntIncomeSvc;

	// 每天凌晨1点执行
	@Scheduled(cron = "${pnt.executeIncomeTaskTime:0 0 1 * * ?}")
	public void executeTasks() {
		_log.info("定时执行需要积分收益的任务");
		try {
			pntIncomeSvc.executePointIncomeTask();
		} catch (final RuntimeException e) {
			_log.error("执行积分收益的任务失败", e);
		}
	}
}
