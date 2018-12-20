package rebue.pnt.jo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zbz
 */
@Entity
@Table(name = "PNT_ACCOUNT")
@Getter
@Setter
@ToString
public class PntAccountJo implements Serializable {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Id
    @Basic(optional = false)
    @Column(name = "ID", nullable = false, length = 19)
    private Long id;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "POINTS", nullable = false, precision = 18, scale = 4)
    private BigDecimal points;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "INCOME", nullable = false, precision = 20, scale = 10)
    private BigDecimal income;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "TOTAL_INCOME", nullable = false, precision = 20, scale = 10)
    private BigDecimal totalIncome;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "IS_LOCKED", nullable = false, length = 3)
    private Boolean isLocked;

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Basic(optional = false)
    @Column(name = "MODIFIED_TIMESTAMP", nullable = false, length = 19)
    private Long modifiedTimestamp;

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
        PntAccountJo other = (PntAccountJo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<PntIncomeLogJo> pntIncomeLogList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountId")
    private List<PntPointsLogJo> pntPointsLogList;
}
