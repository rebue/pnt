package rebue.pnt.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import java.math.BigDecimal;

/**
积分日志

数据库表: PNT_LOG

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class PntLogMo implements Serializable {
    /**
    积分日志ID
    
    数据库字段: PNT_LOG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    积分账户ID(等于SUC的用户ID)
    
    数据库字段: PNT_LOG.ACCOUNT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long accountId;

    /**
    积分日志类型ID
    
    数据库字段: PNT_LOG.LOG_TYPE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long logTypeId;

    /**
    改变积分的数量
    
    数据库字段: PNT_LOG.CHANGED_POINTS
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private BigDecimal changedPoints;

    /**
    改变积分的标题
    
    数据库字段: PNT_LOG.CHANGED_TITILE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String changedTitile;

    /**
    改变积分的详情
    
    数据库字段: PNT_LOG.CHANGED_DETAIL
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String changedDetail;

    /**
    订单ID
    
    数据库字段: PNT_LOG.ORDER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long orderId;

    /**
    订单详情ID
    
    数据库字段: PNT_LOG.ORDER_DETAIL_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long orderDetailId;

    /**
    改变积分的时间戳
    
    数据库字段: PNT_LOG.CHANGED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long changedTimestamp;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    积分日志ID
    
    数据库字段: PNT_LOG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    积分日志ID
    
    数据库字段: PNT_LOG.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    积分账户ID(等于SUC的用户ID)
    
    数据库字段: PNT_LOG.ACCOUNT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getAccountId() {
        return accountId;
    }

    /**
    积分账户ID(等于SUC的用户ID)
    
    数据库字段: PNT_LOG.ACCOUNT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
    积分日志类型ID
    
    数据库字段: PNT_LOG.LOG_TYPE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getLogTypeId() {
        return logTypeId;
    }

    /**
    积分日志类型ID
    
    数据库字段: PNT_LOG.LOG_TYPE_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setLogTypeId(Long logTypeId) {
        this.logTypeId = logTypeId;
    }

    /**
    改变积分的数量
    
    数据库字段: PNT_LOG.CHANGED_POINTS
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public BigDecimal getChangedPoints() {
        return changedPoints;
    }

    /**
    改变积分的数量
    
    数据库字段: PNT_LOG.CHANGED_POINTS
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setChangedPoints(BigDecimal changedPoints) {
        this.changedPoints = changedPoints;
    }

    /**
    改变积分的标题
    
    数据库字段: PNT_LOG.CHANGED_TITILE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getChangedTitile() {
        return changedTitile;
    }

    /**
    改变积分的标题
    
    数据库字段: PNT_LOG.CHANGED_TITILE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setChangedTitile(String changedTitile) {
        this.changedTitile = changedTitile;
    }

    /**
    改变积分的详情
    
    数据库字段: PNT_LOG.CHANGED_DETAIL
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getChangedDetail() {
        return changedDetail;
    }

    /**
    改变积分的详情
    
    数据库字段: PNT_LOG.CHANGED_DETAIL
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setChangedDetail(String changedDetail) {
        this.changedDetail = changedDetail;
    }

    /**
    订单ID
    
    数据库字段: PNT_LOG.ORDER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOrderId() {
        return orderId;
    }

    /**
    订单ID
    
    数据库字段: PNT_LOG.ORDER_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
    订单详情ID
    
    数据库字段: PNT_LOG.ORDER_DETAIL_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOrderDetailId() {
        return orderDetailId;
    }

    /**
    订单详情ID
    
    数据库字段: PNT_LOG.ORDER_DETAIL_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    /**
    改变积分的时间戳
    
    数据库字段: PNT_LOG.CHANGED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getChangedTimestamp() {
        return changedTimestamp;
    }

    /**
    改变积分的时间戳
    
    数据库字段: PNT_LOG.CHANGED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setChangedTimestamp(Long changedTimestamp) {
        this.changedTimestamp = changedTimestamp;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accountId=").append(accountId);
        sb.append(", logTypeId=").append(logTypeId);
        sb.append(", changedPoints=").append(changedPoints);
        sb.append(", changedTitile=").append(changedTitile);
        sb.append(", changedDetail=").append(changedDetail);
        sb.append(", orderId=").append(orderId);
        sb.append(", orderDetailId=").append(orderDetailId);
        sb.append(", changedTimestamp=").append(changedTimestamp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
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
        PntLogMo other = (PntLogMo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }
}