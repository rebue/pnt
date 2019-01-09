package rebue.pnt.svc;

import java.math.BigDecimal;

import com.github.pagehelper.PageInfo;

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
     * 添加积分交易
     * 
     * @param to
     * @return
     */
    Ro addPointTrade(AddPointTradeTo to);

    /**
     * 根据用户id查询积分日志
     * 
     * @param accountId
     *            积分账户ID
     */
    PageInfo<PntPointLogMo> listByAccountId(Long accountId, int pageNum, int pageSize);

//    /**
//     * 根据账号id获取今天00:00:00之前最后一个修改后的积分
//     * 
//     * @param accountId
//     * @return
//     */
//    BigDecimal getPointAfterChangedByAccountId(Long accountId);

    /**
     * 获取账户某日的积分(指定日期24点时的当时积分)
     * 
     * @param accountId
     *            积分账户ID
     * @param statDate
     *            统计的日期
     * @return 获取账户某一天的积分
     */
    BigDecimal getPointsOfDate(Long accountId, java.sql.Date statDate);
}
