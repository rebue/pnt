package rebue.pnt.svc.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.pnt.dao.PntAccountDao;
import rebue.pnt.jo.PntAccountJo;
import rebue.pnt.mapper.PntAccountMapper;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.svc.PntAccountSvc;
import rebue.pnt.svc.PntPointLogSvc;
import rebue.pnt.to.AddPointTradeTo;
import rebue.pnt.to.ModifyIncomeTo;
import rebue.pnt.to.ModifyPointTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.BaseSvcImpl;

/**
 * 积分账户信息
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
public class PntAccountSvcImpl extends BaseSvcImpl<java.lang.Long, PntAccountJo, PntAccountDao, PntAccountMo, PntAccountMapper> implements PntAccountSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntAccountSvcImpl.class);

    @Resource
    private PntPointLogSvc pntPointLogSvc;

    /**
     *  添加积分账号信息
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(final PntAccountMo mo) {
        _log.info("添加积分账户信息");
        Long accountId = mo.getId();
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            accountId = _idWorker.getId();
            mo.setId(accountId);
        }
        final int addResult = super.add(mo);
        if (addResult == 1) {
            final AddPointTradeTo to = new AddPointTradeTo();
            to.setAccountId(accountId);
            to.setPointLogType((byte) 5);
            to.setChangedTitile("大卖网络-新用户奖励积分");
            to.setOrderId(_idWorker.getId());
            to.setChangedPoint(BigDecimal.valueOf(10));
            final Ro addPointTradeRo = pntPointLogSvc.addPointTrade(to);
            if (addPointTradeRo.getResult() != ResultDic.SUCCESS) {
                _log.error("添加积分账号信息添加一笔积分交易出现错误，请求的参数为：{}", mo);
                return -1;
            }
            return 1;
        }
        return -1;
    }

    /**
     *  获取需要计算日收益的账户列表
     *
     *  @param fetchCount 获取结果限制数量
     */
    @Override
    public List<PntAccountMo> listToCalcDayIncome(final int fetchCount) {
        _log.info("获取需要计算日收益的账户列表的参数: fetchCount-{}", fetchCount);
        // 昨天时间戳
        Long yesterdayTimestamp = System.currentTimeMillis() - 24 * 60 * 60 * 1000;
        final java.sql.Date yesterday = new java.sql.Date(yesterdayTimestamp);
        _log.debug("昨日: {}", yesterday);
        // 昨天的注册时间
        Date yesterdayRegTime = new Date(yesterday.getTime());
        return _mapper.listToCalcDayIncome(yesterday, fetchCount, yesterdayRegTime);
    }

    /**
     *  修改积分信息
     *
     *  @param to
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro modifyPoint(final ModifyPointTo to) {
        _log.info("修改积分账号信息的请求参数为：{}", to);
        final Ro ro = new Ro();
        if (to.getAccountId() == null || to.getNewPoint() == null || to.getOldPoint() == null || to.getNewModifiedTimestamp() == null || to.getOldModifiedTimestamp() == null) {
            _log.error("修改积分信息时出现参数错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        _log.info("修改积分信息的参数为：{}", to);
        final int modifyAccountResult = _mapper.updatePoint(to.getAccountId(), to.getNewPoint(), to.getOldPoint(), to.getNewModifiedTimestamp(), to.getOldModifiedTimestamp());
        _log.info("修改积分信息的返回值为：{}", modifyAccountResult);
        if (modifyAccountResult != 1) {
            _log.error("修改积分信息 出现错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("修改失败");
            return ro;
        }
        _log.info("修改积分信息成功，请求的参数为：{}", to);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("修改成功");
        return ro;
    }

    /**
     *  修改收益信息
     *
     *  @param to
     *  @return
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro modifyIncome(final ModifyIncomeTo to) {
        _log.info("修改收益信息的参数为：{}", to);
        final Ro ro = new Ro();
        if (to.getId() == null || to.getNewIncome() == null || to.getOldIncome() == null || to.getNewTotalIncome() == null || to.getOldTotalIncome() == null || to.getNewModifiedTimestamp() == null || to.getOldModifiedTimestamp() == null) {
            _log.error("修改收益时出现参数错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        _log.info("修改收益信息的参数为：{}", to);
        final int updateIncomeResult = _mapper.updateIncome(to);
        _log.info("修改收益信息的返回值为：{}", updateIncomeResult);
        if (updateIncomeResult != 1) {
            _log.error("修改收益出现错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("修改失败");
            return ro;
        }
        _log.info("修改收益成功，请求的参数为：{}", to);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("修改成功");
        return ro;
    }

    /**
     *  积分充值
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro rechargePoint(ModifyPointTo to) {
        _log.info("积分充值的请求参数：{}", to);
        final AddPointTradeTo addTo = new AddPointTradeTo();
        addTo.setAccountId(to.getAccountId());
        addTo.setPointLogType((byte) 5);
        addTo.setChangedTitile("大卖网络-积分充值");
        addTo.setOrderId(_idWorker.getId());
        addTo.setChangedPoint(to.getNewPoint());
        final Ro addPointTradeRo = pntPointLogSvc.addPointTrade(addTo);
        _log.info("积分充值的请求结果：{}", addPointTradeRo);
        return addPointTradeRo;
    }
    
    /**
     * 根据限制数量查询积分账号信息
     * @param limitCount
     * @return
     */
    @Override
    public List<PntAccountMo> pntAccountByLimitCountList(Integer pageNum, Integer limitCount){
    	_log.info("根据限制数量查询积分账号信息的参数为：limitCount-{}, pageNum-{}", limitCount, pageNum);
    	return _mapper.selectPntAccountByLimitCount(pageNum * limitCount, limitCount);
    }
}
