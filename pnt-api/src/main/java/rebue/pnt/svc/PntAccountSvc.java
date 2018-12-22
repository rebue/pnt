package rebue.pnt.svc;

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
     *  修改积分账号信息
     *  @param to
     *  @return
     */
    Ro modifyPoint(ModifyPointTo to);

    /**
     * 修改收益信息
     * @param to
     * @return
     */
    Ro modifyIncome(ModifyIncomeTo to);
}
