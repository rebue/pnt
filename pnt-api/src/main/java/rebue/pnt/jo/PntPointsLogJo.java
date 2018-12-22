package rebue.pnt.jo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The persistent class for the PNT_POINTS_LOG database table.
 * @mbg.generated 自动生成，如需修改，请删除本行
 */
@Entity
@Table(name = "PNT_POINTS_LOG")
@Getter
@Setter
@ToString
public class PntPointsLogJo implements Serializable {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *  积分日志ID
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, length = 19)
    private Long id;

    /**
     *  积分日志类型
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "POINTS_LOG_TYPE", nullable = false, length = 3)
    private Byte pointsLogType;

    /**
     *  改变前的积分
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "POINTS_BEFORE_CHANGED", nullable = false, precision = 18, scale = 4)
    private BigDecimal pointsBeforeChanged;

    /**
     *  改变的积分
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "CHANGED_POINTS", nullable = false, precision = 18, scale = 4)
    private BigDecimal changedPoints;

    /**
     *  改变后的积分
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "POINTS_AFTER_CHANGED", nullable = false, precision = 18, scale = 4)
    private BigDecimal pointsAfterChanged;

    /**
     *  改变积分的标题
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "CHANGED_TITILE", nullable = false, length = 30)
    private String changedTitile;

    /**
     *  改变积分的详情
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = true)
    @Column(name = "CHANGED_DETAIL", nullable = true, length = 200)
    private String changedDetail;

    /**
     *  订单ID
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "ORDER_ID", nullable = false, length = 19)
    private Long orderId;

    /**
     *  订单详情ID
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = true)
    @Column(name = "ORDER_DETAIL_ID", nullable = true, length = 19)
    private Long orderDetailId;

    /**
     *  修改时间戳
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "MODIFIED_TIMESTAMP", nullable = false, length = 19)
    private Long modifiedTimestamp;

    /**
     *  旧修改时间戳
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "OLD_MODIFIED_TIMESTAMP", nullable = false, length = 19)
    private Long oldModifiedTimestamp;

    /**
     *  积分账户
     *
     *  @mbg.generated 自动生成，如需修改，请删除本行
     */
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false)
    private PntAccountJo account;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PntPointsLogJo other = (PntPointsLogJo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
