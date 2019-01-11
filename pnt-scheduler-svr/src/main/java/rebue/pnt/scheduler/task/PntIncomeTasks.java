package rebue.pnt.scheduler.task;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.svr.feign.PntAccountSvc;
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

	@Resource
	private PntAccountSvc pntAccountSvc;

	/**
	 * 获取日收益的条数
	 */
	@Value("${pnt.fetchDayIncomeCount}")
	private Integer fetchDayIncomeCount;

	// 每天凌晨1点执行
	@Scheduled(cron = "${pnt.executeIncomeTaskTime:0 0 1 * * ?}")
	public void executeTasks() {
		_log.info("定时执行需要积分收益的任务");
		try {
			while (true) {
				try {
					_log.info("开始获取需要计算日收益的账户列表");
					List<PntAccountMo> listToCalcDayIncome = pntAccountSvc.listToCalcDayIncome(fetchDayIncomeCount);
					_log.info("开始获取需要计算日收益的账户列表的返回值为：{}", String.valueOf(listToCalcDayIncome));
					if (listToCalcDayIncome == null || listToCalcDayIncome.isEmpty()) {
						break;
					}
					for (PntAccountMo pntAccountMo : listToCalcDayIncome) {
						try {
							_log.info("执行账户日收益的参数为：{}", pntAccountMo);
							pntIncomeSvc.executePointIncomeTask(pntAccountMo);
							_log.info("执行账号日收益成功");
							Thread.sleep(1);
						} catch (Exception e) {
							_log.error("执行账户日收益失败，出现的异常为：{}", e);
						}
						Thread.sleep(1);
					}
				} catch (Exception e) {
					_log.error("获取需要计算日收益的账户列表失败, 出现的异常为：{}", e);
				}
			}
		} catch (final RuntimeException e) {

			_log.error("执行积分收益任务时发生系统中断, 异常为：{}", e);
		}
	}
}
