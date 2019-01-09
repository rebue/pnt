package rebue.pnt.scheduler.task;

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

	private PntIncomeSvc pntIncomeSvc;

	// 每天凌晨1点、中午12点执行
	@Scheduled(cron = "0 0 1 * * ?")
	public void executeTasks() {
		_log.info("定时执行需要订单结算的任务");
		try {
			pntIncomeSvc.executePointIncomeTask();
		} catch (final RuntimeException e) {
			_log.error("执行订单结算的任务失败", e);
		}
	}
}
