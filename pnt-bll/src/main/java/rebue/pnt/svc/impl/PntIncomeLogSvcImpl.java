package rebue.pnt.svc.impl;

import java.math.BigDecimal;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.pnt.dao.PntIncomeLogDao;
import rebue.pnt.dic.IncomeLogTypeDic;
import rebue.pnt.jo.PntIncomeLogJo;
import rebue.pnt.mapper.PntIncomeLogMapper;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.mo.PntIncomeLogMo;
import rebue.pnt.svc.PntAccountSvc;
import rebue.pnt.svc.PntIncomeLogSvc;
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
    public int add(PntIncomeLogMo mo) {
        _log.info("添加收益日志");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    @Resource
    private PntAccountSvc pntAccountSvc;

    @Resource
    private PntIncomeLogSvc thisSvc;

    /**
     *  添加一笔收益交易
     *  流程：
     *  	1、查询账号信息并判断账号是否为空和是否已被锁定
     *  	2、修改收益信息
     *  	3、添加收益日志
     *  @param to
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro addIncomeTrade(AddIncomeTradeTo to) {
        _log.info("添加一笔收益交易的参数为：{}", to);
        Ro ro = new Ro();
        if (to.getAccountId() == null || to.getIncomeLogType() == null || to.getChangedIncome() == null || to.getChangedTitile() == null || to.getModifiedTimestamp() == null) {
            _log.error("添加一笔收益交易时出现参数有误，请求的参数为：{}", to);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数有误");
            return ro;
        }
        _log.info("添加一笔收益交易查询账号信息的参数为：{}", to.getAccountId());
        PntAccountMo accountMo = pntAccountSvc.getById(to.getAccountId());
        _log.info("添加一笔收益交易查询账号信息的返回值为：{}", accountMo);
        if (accountMo == null) {
            _log.error("添加一笔收益交易时发现没有该账号信息，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("没有发现该账号");
            return ro;
        }
        if (accountMo.getIsLocked()) {
            _log.error("添加一笔收益交易时发现该账号已被锁定，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("账号已被锁定");
            return ro;
        }
        // 新的当前收益
        BigDecimal newIncome = BigDecimal.ZERO;
        // 新的总收益
        BigDecimal newTotalIncome = accountMo.getTotalIncome();
        switch(IncomeLogTypeDic.getItem(to.getIncomeLogType())) {
            case DAY_INCOME:
                // 新的当前收益 = 旧的当前收益 + 改变的收益
                newIncome = accountMo.getIncome().add(to.getChangedIncome());
                // 新的总收益 = 旧的总收益 + 改变的收益
                newTotalIncome = accountMo.getTotalIncome().add(to.getChangedIncome());
                break;
            case TRANSFER_OUT_INCOME:
                // 新的当前收益 = 旧的当前收益 - 改变的收益
                newIncome = accountMo.getIncome().subtract(to.getChangedIncome());
            default:
                break;
        }
        ModifyIncomeTo modifyIncomeTo = new ModifyIncomeTo();
        modifyIncomeTo.setAccountId(to.getAccountId());
        modifyIncomeTo.setNewIncome(newIncome);
        modifyIncomeTo.setOldIncome(accountMo.getIncome());
        modifyIncomeTo.setNewTotalIncome(newTotalIncome);
        modifyIncomeTo.setOldTotalIncome(accountMo.getTotalIncome());
        modifyIncomeTo.setNewModifiedTimestamp(to.getModifiedTimestamp());
        modifyIncomeTo.setOldModifiedTimestamp(accountMo.getModifiedTimestamp());
        _log.info("添加一笔收益交易修改收益信息的参数为：{}", modifyIncomeTo);
        Ro modifyIncomeRo = pntAccountSvc.modifyIncome(modifyIncomeTo);
        _log.info("添加一笔收益交易修改收益信息的返回值为：{}", modifyIncomeRo);
        if (modifyIncomeRo.getResult() != ResultDic.SUCCESS) {
            _log.error("添加一笔收益修改收益信息时出现错误，请求的参数为：{}", to);
            return modifyIncomeRo;
        }
        PntIncomeLogMo incomeLogMo = new PntIncomeLogMo();
        incomeLogMo.setAccountId(to.getAccountId());
        incomeLogMo.setIncomeLogType(to.getIncomeLogType());
        incomeLogMo.setIncomeBeforeChanged(accountMo.getIncome());
        incomeLogMo.setChangedIncome(to.getChangedIncome());
        incomeLogMo.setIncomeAfterChanged(newIncome);
        incomeLogMo.setChangedTitile(to.getChangedTitile());
        incomeLogMo.setChangedDetail(to.getChangedDetail());
        incomeLogMo.setStatDate(to.getStatDate());
        incomeLogMo.setModifiedTimestamp(to.getModifiedTimestamp());
        incomeLogMo.setOldModifiedTimestamp(accountMo.getModifiedTimestamp());
        _log.info("添加一笔收益交易添加收益日志的参数为：{}", incomeLogMo);
        int addResult = thisSvc.add(incomeLogMo);
        _log.info("添加一笔收益交易添加收益日志的返回值为：{}", addResult);
        if (addResult != 1) {
            _log.error("添加一笔收益添加收益日志出现错误，请求的参数为：{}", to);
            throw new RuntimeException("添加日志出错");
        }
        _log.info("添加一笔收益成功，请求的参数为：{}", to);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("添加成功");
        return ro;
    }
    
    /**
     * 统计昨日收益
     * @param accountId
     * @return
     */
    @Override
    public BigDecimal countYesterdayIncome(Long accountId) {
    	_log.info("统计昨日收益的参数为：{}", accountId);
    	return _mapper.countYesterdayIncome(accountId);
    }
}
