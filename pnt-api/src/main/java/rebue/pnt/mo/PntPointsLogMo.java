package rebue.pnt.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 积分日志
 *
 * 数据库表: PNT_POINTS_LOG
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class PntPointsLogMo implements Serializable {

    /**
     *    积分日志ID
     *
     *    数据库字段: PNT_POINTS_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_POINTS_LOG.ACCOUNT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long accountId;

    /**
     *    积分日志类型
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_LOG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte pointsLogType;

    /**
     *    改变前的积分
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_BEFORE_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal pointsBeforeChanged;

    /**
     *    改变的积分
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_POINTS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal changedPoints;

    /**
     *    改变后的积分(改变后的积分=改变前的积分+改变的积分)
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_AFTER_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal pointsAfterChanged;

    /**
     *    改变积分的标题
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_TITILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String changedTitile;

    /**
     *    改变积分的详情
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String changedDetail;

    /**
     *    订单ID
     *
     *    数据库字段: PNT_POINTS_LOG.ORDER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orderId;

    /**
     *    订单详情ID
     *
     *    数据库字段: PNT_POINTS_LOG.ORDER_DETAIL_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long orderDetailId;

    /**
     *    修改时间戳
     *
     *    数据库字段: PNT_POINTS_LOG.MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long modifiedTimestamp;

    /**
     *    旧修改时间戳
     *
     *    数据库字段: PNT_POINTS_LOG.OLD_MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long oldModifiedTimestamp;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    积分日志ID
     *
     *    数据库字段: PNT_POINTS_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    积分日志ID
     *
     *    数据库字段: PNT_POINTS_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_POINTS_LOG.ACCOUNT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_POINTS_LOG.ACCOUNT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     *    积分日志类型
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_LOG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getPointsLogType() {
        return pointsLogType;
    }

    /**
     *    积分日志类型
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_LOG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPointsLogType(Byte pointsLogType) {
        this.pointsLogType = pointsLogType;
    }

    /**
     *    改变前的积分
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_BEFORE_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getPointsBeforeChanged() {
        return pointsBeforeChanged;
    }

    /**
     *    改变前的积分
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_BEFORE_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPointsBeforeChanged(BigDecimal pointsBeforeChanged) {
        this.pointsBeforeChanged = pointsBeforeChanged;
    }

    /**
     *    改变的积分
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_POINTS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getChangedPoints() {
        return changedPoints;
    }

    /**
     *    改变的积分
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_POINTS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setChangedPoints(BigDecimal changedPoints) {
        this.changedPoints = changedPoints;
    }

    /**
     *    改变后的积分(改变后的积分=改变前的积分+改变的积分)
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_AFTER_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getPointsAfterChanged() {
        return pointsAfterChanged;
    }

    /**
     *    改变后的积分(改变后的积分=改变前的积分+改变的积分)
     *
     *    数据库字段: PNT_POINTS_LOG.POINTS_AFTER_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPointsAfterChanged(BigDecimal pointsAfterChanged) {
        this.pointsAfterChanged = pointsAfterChanged;
    }

    /**
     *    改变积分的标题
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_TITILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getChangedTitile() {
        return changedTitile;
    }

    /**
     *    改变积分的标题
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_TITILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setChangedTitile(String changedTitile) {
        this.changedTitile = changedTitile;
    }

    /**
     *    改变积分的详情
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getChangedDetail() {
        return changedDetail;
    }

    /**
     *    改变积分的详情
     *
     *    数据库字段: PNT_POINTS_LOG.CHANGED_DETAIL
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setChangedDetail(String changedDetail) {
        this.changedDetail = changedDetail;
    }

    /**
     *    订单ID
     *
     *    数据库字段: PNT_POINTS_LOG.ORDER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     *    订单ID
     *
     *    数据库字段: PNT_POINTS_LOG.ORDER_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     *    订单详情ID
     *
     *    数据库字段: PNT_POINTS_LOG.ORDER_DETAIL_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    /**
     *    订单详情ID
     *
     *    数据库字段: PNT_POINTS_LOG.ORDER_DETAIL_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
     *    修改时间戳
     *
     *    数据库字段: PNT_POINTS_LOG.MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
     *    修改时间戳
     *
     *    数据库字段: PNT_POINTS_LOG.MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setModifiedTimestamp(Long modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
    }

    /**
     *    旧修改时间戳
     *
     *    数据库字段: PNT_POINTS_LOG.OLD_MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getOldModifiedTimestamp() {
        return oldModifiedTimestamp;
    }

    /**
     *    旧修改时间戳
     *
     *    数据库字段: PNT_POINTS_LOG.OLD_MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setOldModifiedTimestamp(Long oldModifiedTimestamp) {
        this.oldModifiedTimestamp = oldModifiedTimestamp;
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", pointsLogType=").append(pointsLogType);
        sb.append(", pointsBeforeChanged=").append(pointsBeforeChanged);
        sb.append(", changedPoints=").append(changedPoints);
        sb.append(", pointsAfterChanged=").append(pointsAfterChanged);
        sb.append(", changedTitile=").append(changedTitile);
        sb.append(", changedDetail=").append(changedDetail);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderDetailId=").append(orderDetailId);
        sb.append(", modifiedTimestamp=").append(modifiedTimestamp);
        sb.append(", oldModifiedTimestamp=").append(oldModifiedTimestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PntPointsLogMo other = (PntPointsLogMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()));
    }

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}
