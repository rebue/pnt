package rebue.pnt.svc.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rebue.afc.dic.TradeTypeDic;
import rebue.afc.mo.AfcTradeMo;
import rebue.afc.svr.feign.AfcTradeSvc;
import rebue.pnt.dao.PntIncomeLogDao;
import rebue.pnt.dic.IncomeLogTypeDic;
import rebue.pnt.jo.PntIncomeLogJo;
import rebue.pnt.mapper.PntIncomeLogMapper;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.mo.PntIncomeLogMo;
import rebue.pnt.svc.PntAccountSvc;
import rebue.pnt.svc.PntIncomeLogSvc;
import rebue.pnt.svc.PntPointLogSvc;
import rebue.pnt.to.AddIncomeTradeTo;
import rebue.pnt.to.ModifyIncomeTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.BaseSvcImpl;

/**
 * 收益日志
 *
 * 在单独使用不带任何参数的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class PntIncomeLogSvcImpl extends BaseSvcImpl<java.lang.Long, PntIncomeLogJo, PntIncomeLogDao, PntIncomeLogMo, PntIncomeLogMapper> implements PntIncomeLogSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntIncomeLogSvcImpl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(final PntIncomeLogMo mo) {
        _log.info("添加收益日志");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    @Resource
    private PntAccountSvc   pntAccountSvc;

    @Resource
    private PntIncomeLogSvc thisSvc;

    @Resource
    private PntPointLogSvc  pntPointLogSvc;
    
    @Resource
    private AfcTradeSvc afcTradeSvc;

    /**
     * 每日利率 = 年化利率12% / 12个月 / 30天
     */
    @Value("${pnt.dailyInterestRate:0.000333}")
    private BigDecimal      dailyInterestRate;

    /**
     * 添加一笔收益交易
     * 流程：
     * 1、查询账号信息并判断账号是否为空和是否已被锁定
     * 2、修改收益信息
     * 3、添加收益日志
     *
     * @param to
     * @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro addIncomeTrade(final AddIncomeTradeTo to) {
        _log.info("添加一笔收益交易的参数为：{}", to);
        final Ro ro = new Ro();
        if (to.getAccountId() == null || to.getIncomeLogType() == null || to.getChangedIncome() == null || to.getChangedTitile() == null || to.getModifiedTimestamp() == null) {
            _log.error("添加一笔收益交易时出现参数有误，请求的参数为：{}", to);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数有误");
            return ro;
        }
        _log.info("添加一笔收益交易查询账号信息的参数为：{}", to.getAccountId());
        final PntAccountMo accountMo = pntAccountSvc.getById(to.getAccountId());
        _log.info("添加一笔收益交易查询账号信息的返回值为：{}", accountMo);
        if (accountMo == null) {
            _log.error("添加一笔收益交易时发现没有该账号信息，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("没有发现该账号");
            return ro;
        }
        // 新的当前收益
        BigDecimal newIncome = BigDecimal.ZERO;
        // 新的总收益
        BigDecimal newTotalIncome = accountMo.getTotalIncome();
        // 当前时间
        Date dayIncomeStatDate = null;
        switch (IncomeLogTypeDic.getItem(to.getIncomeLogType())) {
        case DAY_INCOME:
            // 新的当前收益 = 旧的当前收益 + 改变的收益
            newIncome = accountMo.getIncome().add(to.getChangedIncome());
            // 新的总收益 = 旧的总收益 + 改变的收益
            newTotalIncome = accountMo.getTotalIncome().add(to.getChangedIncome());
            // 当前时间
            dayIncomeStatDate = new Date();
            break;
        case TRANSFER_OUT_INCOME:
            // 新的当前收益 = 旧的当前收益 - 改变的收益
            newIncome = accountMo.getIncome().subtract(to.getChangedIncome());
        default:
            break;
        }
        final ModifyIncomeTo modifyIncomeTo = new ModifyIncomeTo();
        modifyIncomeTo.setId(to.getAccountId());
        modifyIncomeTo.setNewIncome(newIncome);
        modifyIncomeTo.setOldIncome(accountMo.getIncome());
        modifyIncomeTo.setNewTotalIncome(newTotalIncome);
        modifyIncomeTo.setOldTotalIncome(accountMo.getTotalIncome());
        modifyIncomeTo.setNewModifiedTimestamp(to.getModifiedTimestamp());
        modifyIncomeTo.setOldModifiedTimestamp(accountMo.getModifiedTimestamp());
        modifyIncomeTo.setDayIncomeStatDate(dayIncomeStatDate);
        _log.info("添加一笔收益交易修改收益信息的参数为：{}", modifyIncomeTo);
        final Ro modifyIncomeRo = pntAccountSvc.modifyIncome(modifyIncomeTo);
        _log.info("添加一笔收益交易修改收益信息的返回值为：{}", modifyIncomeRo);
        if (modifyIncomeRo.getResult() != ResultDic.SUCCESS) {
            _log.error("添加一笔收益修改收益信息时出现错误，请求的参数为：{}", to);
            return modifyIncomeRo;
        }
        final PntIncomeLogMo incomeLogMo = new PntIncomeLogMo();
        incomeLogMo.setAccountId(to.getAccountId());
        incomeLogMo.setIncomeLogType(to.getIncomeLogType());
        incomeLogMo.setIncomeBeforeChanged(accountMo.getIncome());
        incomeLogMo.setChangedIncome(to.getChangedIncome());
        incomeLogMo.setIncomeAfterChanged(newIncome);
        incomeLogMo.setChangedTitile(to.getChangedTitile());
        incomeLogMo.setStatDate(to.getStatDate());
        incomeLogMo.setModifiedTimestamp(to.getModifiedTimestamp());
        _log.info("添加一笔收益交易添加收益日志的参数为：{}", incomeLogMo);
        final int addResult = thisSvc.add(incomeLogMo);
        _log.info("添加一笔收益交易添加收益日志的返回值为：{}", addResult);
        if (addResult != 1) {
            _log.error("添加一笔收益添加收益日志出现错误，请求的参数为：{}", to);
            throw new RuntimeException("添加日志出错");
        }
        
        System.out.println("to.getIncomeLogType() == IncomeLogTypeDic.DAY_INCOME.getCode()=" + (to.getIncomeLogType() == IncomeLogTypeDic.DAY_INCOME.getCode()));
        if (to.getIncomeLogType() == IncomeLogTypeDic.DAY_INCOME.getCode()) {
        	System.out.println("newIncome.compareTo(BigDecimal.ONE)=" + (newIncome.compareTo(BigDecimal.ONE)));
        	if (newIncome.compareTo(BigDecimal.ONE) > 0) {
        		AfcTradeMo afcTradeMo = new AfcTradeMo();
        		afcTradeMo.setOrderId(incomeLogMo.getId().toString());
        		afcTradeMo.setTradeType((byte) TradeTypeDic.POINT_INCOME_WITHDRAW.getCode());
        		afcTradeMo.setAccountId(to.getAccountId());
        		afcTradeMo.setTradeAmount(newIncome.setScale(2, BigDecimal.ROUND_DOWN));
        		afcTradeMo.setTradeTitle("大卖网络-用户收益提现");
        		afcTradeMo.setTradeTime(dayIncomeStatDate);
        		afcTradeMo.setOpId(0L);
        		_log.info("添加一笔积分收益交易添加账号交易的参数为：{}", afcTradeMo);
        		afcTradeSvc.addTrade(afcTradeMo);
			}
		}
        
        _log.info("添加一笔收益成功，请求的参数为：{}", to);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("添加成功");
        return ro;
    }

    /**
     * 获取昨日收益
     *
     * @param accountId
     *            用户积分账户
     * @return 昨日的收益
     */
    @Override
    public BigDecimal getIncomeOfYesterday(final Long accountId) {
        _log.info("统计昨日收益的参数为：{}", accountId);
        final java.sql.Date yesterday = new java.sql.Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        _log.debug("昨日: {}", yesterday);
        return _mapper.getIncomeOfDate(accountId, yesterday, IncomeLogTypeDic.DAY_INCOME);
    }

    /**
     * 执行积分收益任务
     */
    @Override
    public void executePointIncomeTask() {
        _log.info("执行积分收益任务开始");
        try {
            while (true) {
                _log.info("获取需要计算日收益的账户列表");
                final List<PntAccountMo> pntAccounts = pntAccountSvc.listToCalcDayIncome(1000);
                _log.info("获取需要计算日收益的账户列表的返回值：{}", pntAccounts);
                if (pntAccounts == null || pntAccounts.isEmpty()) {
                    break;
                }

                final java.sql.Date yesterday = new java.sql.Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
                _log.debug("昨日: {}", yesterday);

                _log.info("开始遍历积分账户给其添加日收益");
                for (final PntAccountMo pntAccount : pntAccounts) {
                    try {
                        if (pntAccount.getDayIncomeStatDate() == null) {
                            _log.info("未曾统计的用户(一般是新用户)，直接添加昨日的收益: 积分账户-{}", pntAccount);
                            thisSvc.addDayIncomeLogOfDate(pntAccount.getId(), yesterday);
                        } else {
                            java.sql.Date statDate = new java.sql.Date(pntAccount.getDayIncomeStatDate().getTime());
                            while (!statDate.after(yesterday)) {
                                _log.info("添加{}的收益: 账户-{}", statDate, pntAccount);
                                thisSvc.addDayIncomeLogOfDate(pntAccount.getId(), statDate);
                                statDate = new java.sql.Date(statDate.getTime() + 24 * 60 * 60 * 1000); // 加1天
                                Thread.sleep(1);
                            }
                        }
                    } catch (final RuntimeException e) {
                        _log.error("给积分账户添加日收益: 积分账户-" + pntAccount, e);
                    }
                    Thread.sleep(1);
                }
                Thread.sleep(1);
            }
        } catch (final InterruptedException e) {
            _log.error("执行积分收益任务时发生系统中断", e);
        }
    }

    /**
     * 添加某一天的日收益日志
     * 
     * @param accountId
     *            用户积分账户
     * @param statDate
     *            统计日期
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void addDayIncomeLogOfDate(final Long accountId, final java.sql.Date statDate) {
        _log.info("添加账户{}的{}的日收益日志", accountId, statDate);
        _log.info("获取账户某日的积分(指定日期24点时的当时积分)");
        final BigDecimal points = pntPointLogSvc.getPointsOfDate(accountId, statDate);
        _log.info("获取账户某日的积分(指定日期24点时的当时积分)的返回值: {}", points);
        if (points == null || BigDecimal.ZERO.compareTo(points) >= 0) {
            _log.info("账户{}的{}的积分为{}，不能添加日收益", accountId, statDate, points);
            return;
        }
        final BigDecimal changedIncome = points.multiply(dailyInterestRate);
        _log.info("账户{}的{}的日收益应该为: {}", accountId, statDate, changedIncome);

        final AddIncomeTradeTo addIncomeTradeTo = new AddIncomeTradeTo();
        addIncomeTradeTo.setAccountId(accountId);
        addIncomeTradeTo.setIncomeLogType((byte) IncomeLogTypeDic.DAY_INCOME.getCode());
        addIncomeTradeTo.setChangedIncome(changedIncome);
        addIncomeTradeTo.setChangedTitile("大卖网络-每日积分收益");
        addIncomeTradeTo.setStatDate(new Date());
        addIncomeTradeTo.setModifiedTimestamp(_idWorker.getId());
        _log.info("添加一笔积分收益的参数为：{}", addIncomeTradeTo);
        final Ro addIncomeTradeRo = thisSvc.addIncomeTrade(addIncomeTradeTo);
        _log.info("添加一笔积分收益的返回值为：{}", addIncomeTradeRo);
        if (addIncomeTradeRo.getResult() != ResultDic.SUCCESS) {
            throw new RuntimeException("执行积分收益任务添加一笔积分收益出现错误");
        }
    }
}
