package rebue.pnt.svc;

import rebue.pnt.jo.PntPointLogJo;
import rebue.pnt.mo.PntPointLogMo;
import rebue.pnt.to.AddPointTradeTo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.BaseSvc;

/**
 * 积分日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface PntPointLogSvc extends BaseSvc<java.lang.Long, PntPointLogMo, PntPointLogJo> {

    /**
     *  添加积分交易
     *  @param to
     *  @return
     */
    Ro addPointTrade(AddPointTradeTo to);
}
