package rebue.pnt.svc;

import rebue.pnt.jo.PntPointsLogJo;
import rebue.pnt.mo.PntPointsLogMo;
import rebue.pnt.to.AddPointTradeTo;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.BaseSvc;

/**
 * 积分日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public interface PntPointsLogSvc extends BaseSvc<java.lang.Long, PntPointsLogMo, PntPointsLogJo> {

    /**
     *  添加积分交易
     *  @param to
     *  @return
     */
    Ro addPointTrade(AddPointTradeTo to);
}
