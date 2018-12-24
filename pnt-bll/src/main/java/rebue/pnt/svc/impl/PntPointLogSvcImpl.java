package rebue.pnt.svc.impl;

import java.math.BigDecimal;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.pnt.dao.PntPointLogDao;
import rebue.pnt.dic.PointLogTypeDic;
import rebue.pnt.jo.PntPointLogJo;
import rebue.pnt.mapper.PntPointLogMapper;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.mo.PntPointLogMo;
import rebue.pnt.svc.PntAccountSvc;
import rebue.pnt.svc.PntPointLogSvc;
import rebue.pnt.to.AddPointTradeTo;
import rebue.pnt.to.ModifyPointTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.BaseSvcImpl;

/**
 * 积分日志
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
public class PntPointLogSvcImpl extends BaseSvcImpl<java.lang.Long, PntPointLogJo, PntPointLogDao, PntPointLogMo, PntPointLogMapper> implements PntPointLogSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntPointLogSvcImpl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(PntPointLogMo mo) {
        _log.info("添加积分日志");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId() == 0) {
            mo.setId(_idWorker.getId());
        }
        return super.add(mo);
    }

    @Resource
    private PntAccountSvc pntAccountSvc;

    @Resource
    private PntPointLogSvc thisSvc;

    /**
     *  添加积分 2018年12月19日17:12:15 流程： 1、查询积分账号信息并判断账号是否存在和是否已锁定 2、修改积分账号信息 3、添加积分日志
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public Ro addPointTrade(AddPointTradeTo to) {
        _log.info("添加积分交易的请求参数为：{}", to);
        Ro ro = new Ro();
        if (to.getAccountId() == null || to.getOrderId() == null || to.getPointsLogType() == null || to.getChangedPoint() == null || to.getChangedTitile() == null || to.getModifiedTimestamp() == null) {
            _log.error("添加积分交易时出现参数错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.PARAM_ERROR);
            ro.setMsg("参数错误");
            return ro;
        }
        _log.info("添加积分交易第一步开始，请求的参数为：{}", to);
        _log.info("添加积分交易查询积分账号信息的参数为：{}", to.getAccountId());
        PntAccountMo accountMo = pntAccountSvc.getById(to.getAccountId());
        _log.info("添加积分交易查询积分账号信息的返回值为：{}", accountMo);
        if (accountMo == null) {
            _log.error("添加积分交易查询积分账号信息时发现没有该积分账号信息，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("没有发现该积分账号");
            return ro;
        }
        if (accountMo.getIsLocked()) {
            _log.error("添加积分交易时发现该账号已被锁定，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("该账号已被锁定");
            return ro;
        }
        // 新当前积分 = 修改的积分 + 旧的当前积分
        BigDecimal newPoint = to.getChangedPoint().add(accountMo.getPoint());
        if (to.getPointsLogType() == PointLogTypeDic.VPAY_WITHDRAW.getCode()) {
            if (newPoint.compareTo(BigDecimal.ZERO) < 0) {
                _log.error("添加积分交易时发现积分不足，请求的参数为：{}", to);
                ro.setResult(ResultDic.FAIL);
                ro.setMsg("积分不足");
                return ro;
            }
        } else if (to.getPointsLogType() == PointLogTypeDic.ORDER_RETURN.getCode()) {
            if (accountMo.getPoint().compareTo(BigDecimal.ZERO) == 0) {
                _log.warn("添加积分交易，积分日志类型为退货时发现该账号积分为0，请求的参数为：{}", to);
                ro.setResult(ResultDic.SUCCESS);
                ro.setMsg("该账号积分为0");
                return ro;
            }
        }
        _log.info("添加积分交易第二步开始，请求的参数为：{}", to);
        ModifyPointTo modifyPointTo = new ModifyPointTo();
        modifyPointTo.setAccountId(to.getAccountId());
        modifyPointTo.setNewPoint(newPoint);
        modifyPointTo.setOldPoint(accountMo.getPoint());
        modifyPointTo.setNewModifiedTimestamp(to.getModifiedTimestamp());
        modifyPointTo.setOldModifiedTimestamp(accountMo.getModifiedTimestamp());
        _log.info("添加积分交易修改积分账号信息的参数为：{}", modifyPointTo);
        Ro modifyPointAccountRo = pntAccountSvc.modifyPoint(modifyPointTo);
        _log.info("添加积分交易修改积分账号信息的返回值为：{}", modifyPointAccountRo);
        if (modifyPointAccountRo.getResult() != ResultDic.SUCCESS) {
            _log.error("添加积分交易修改积分账号信息出现错误，请求的参数为：{}", to);
            ro.setResult(ResultDic.FAIL);
            ro.setMsg("修改积分账号信息失败");
            return ro;
        }
        _log.info("添加积分交易三步开始，请求的参数为：{}", to);
        PntPointLogMo pointLogMo = new PntPointLogMo();
        pointLogMo.setAccountId(to.getAccountId());
        pointLogMo.setPointLogType(to.getPointsLogType());
        pointLogMo.setPointBeforeChanged(accountMo.getPoint());
        pointLogMo.setChangedPoint(to.getChangedPoint());
        pointLogMo.setPointAfterChanged(newPoint);
        pointLogMo.setChangedTitile(to.getChangedTitile());
        pointLogMo.setChangedDetail(to.getChangedDetail());
        pointLogMo.setOrderId(to.getOrderId());
        pointLogMo.setOrderDetailId(to.getOrderDetailId());
        pointLogMo.setModifiedTimestamp(to.getModifiedTimestamp());
        pointLogMo.setOldModifiedTimestamp(accountMo.getModifiedTimestamp());
        _log.info("添加积分交易添加积分日志的参数为：{}", pointLogMo);
        int addPointLogResult = thisSvc.add(pointLogMo);
        _log.info("添加积分交易添加积分日志的返回值为：{}", addPointLogResult);
        if (addPointLogResult != 1) {
            _log.error("添加积分交易添加积分日志出现错误，请求的参数为：{}", pointLogMo);
            throw new RuntimeException("添加日志出错");
        }
        _log.info("添加积分交易成功，请求的参数为：{}", to);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("添加成功");
        return ro;
    }
}