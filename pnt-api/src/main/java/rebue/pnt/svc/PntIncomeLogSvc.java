package rebue.pnt.svc;

import java.math.BigDecimal;
import java.sql.Date;

import rebue.pnt.jo.PntIncomeLogJo;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.mo.PntIncomeLogMo;
import rebue.pnt.to.AddIncomeTradeTo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.BaseSvc;

/**
 * 收益日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface PntIncomeLogSvc extends BaseSvc<java.lang.Long, PntIncomeLogMo, PntIncomeLogJo> {

	/**
	 * 添加一笔收益交易
	 *
	 * @param to
	 * @return
	 */
	Ro addIncomeTrade(AddIncomeTradeTo to);

	/**
	 * 获取昨日收益
	 *
	 * @param accountId 用户积分账户
	 * @return 昨日的收益
	 */
	BigDecimal getIncomeOfYesterday(Long accountId);

	/**
	 * 执行积分收益任务
	 */
	void executePointIncomeTask(PntAccountMo pntAccount);

	/**
	 * 添加某一天的日收益日志
	 * 
	 * @param accountId 用户积分账户
	 * @param statDate  统计日期
	 */
	void addDayIncomeLogOfDate(Long accountId, Date statDate);
}
