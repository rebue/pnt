package rebue.pnt.svc;

import java.util.List;

import rebue.pnt.jo.PntAccountJo;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.to.ModifyIncomeTo;
import rebue.pnt.to.ModifyPointTo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.BaseSvc;

/**
 * 积分账户信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface PntAccountSvc extends BaseSvc<java.lang.Long, PntAccountMo, PntAccountJo> {

    /**
     * 获取需要计算日收益的账户列表
     * 
     * @param fetchCount
     *            获取结果限制数量
     */
    List<PntAccountMo> listToCalcDayIncome(int fetchCount);

    /**
     * 修改积分账号信息
     */
    Ro modifyPoint(ModifyPointTo to);

    /**
     * 修改收益信息
     */
    Ro modifyIncome(ModifyIncomeTo to);
    
    /**
     * 积分充值
     */
    Ro rechargePoint(ModifyPointTo to);
}
