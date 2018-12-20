package rebue.pnt.svc;

import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.to.ModifyPointAccountTo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.MybatisBaseSvc;

/**
 * 积分账户信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface PntAccountSvc extends MybatisBaseSvc<PntAccountMo, java.lang.Long> {

    /**
     *  修改积分账号信息
     *  @param to
     *  @return
     */
    Ro modifyPointAccount(ModifyPointAccountTo to);
}
