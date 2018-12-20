package rebue.pnt.to;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 添加积分交易请求参数
 * @author lbl
 * @version1.0.9
 */
@Data
public class AddPointTradeTo {

	/**
	 * 积分账户ID(等于SUC的用户ID)
	 *
	 * 数据库字段: PNT_POINTS_LOG.ACCOUNT_ID
	 */
	private Long accountId;

	/**
	 * 积分日志类型
	 *
	 * 数据库字段: PNT_POINTS_LOG.POINTS_LOG_TYPE
	 */
	private Byte pointsLogType;

	/**
	 * 改变积分的标题
	 *
	 * 数据库字段: PNT_POINTS_LOG.CHANGED_TITILE
	 */
	private String changedTitile;

	/**
	 * 改变积分的详情(非必填)
	 *
	 * 数据库字段: PNT_POINTS_LOG.CHANGED_DETAIL
	 */
	private String changedDetail;

	/**
	 * 订单ID
	 *
	 * 数据库字段: PNT_POINTS_LOG.ORDER_ID
	 */
	private Long orderId;

	/**
	 * 订单详情ID(非必填)
	 *
	 * 数据库字段: PNT_POINTS_LOG.ORDER_DETAIL_ID
	 */
	private Long orderDetailId;

	/**
	 * 修改时间戳
	 *
	 * 数据库字段: PNT_POINTS_LOG.MODIFIED_TIMESTAMP
	 */
	private Long modifiedTimestamp;
	
	/**
	 * 改变的积分
	 */
	private BigDecimal changedPoints;
}
