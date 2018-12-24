package rebue.pnt.to;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 添加积分交易请求参数
 * 
 * @author lbl
 * @version1.0.9
 */
@Data
public class AddPointTradeTo {

    /**
     * 积分账户ID(等于SUC的用户ID)
     */
    private Long       accountId;

    /**
     * 积分日志类型
     */
    private Byte       pointLogType;

    /**
     * 改变积分的标题
     */
    private String     changedTitile;

    /**
     * 改变积分的详情(非必填)
     */
    private String     changedDetail;

    /**
     * 订单ID
     */
    private Long       orderId;

    /**
     * 订单详情ID(非必填)
     */
    private Long       orderDetailId;

    /**
     * 改变的积分
     */
    private BigDecimal changedPoint;

}
