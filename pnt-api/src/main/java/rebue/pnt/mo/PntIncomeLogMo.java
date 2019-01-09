package rebue.pnt.mo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 收益日志
 *
 * 数据库表: PNT_INCOME_LOG
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class PntIncomeLogMo implements Serializable {

    /**
     *    收益日志ID
     *
     *    数据库字段: PNT_INCOME_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_INCOME_LOG.ACCOUNT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long accountId;

    /**
     *    收益日志类型(1: 日收益； 2: 转出收益)
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_LOG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Byte incomeLogType;

    /**
     *    改变前的收益
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_BEFORE_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal incomeBeforeChanged;

    /**
     *    改变的收益
     *
     *    数据库字段: PNT_INCOME_LOG.CHANGED_INCOME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal changedIncome;

    /**
     *    改变后的收益(改变后的收益=改变前的收益+改变的收益)
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_AFTER_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private BigDecimal incomeAfterChanged;

    /**
     *    改变收益的标题
     *
     *    数据库字段: PNT_INCOME_LOG.CHANGED_TITILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String changedTitile;

    /**
     *    统计日期(日收益的日期)
     *
     *    数据库字段: PNT_INCOME_LOG.STAT_DATE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date statDate;

    /**
     *    修改时间戳
     *
     *    数据库字段: PNT_INCOME_LOG.MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long modifiedTimestamp;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    收益日志ID
     *
     *    数据库字段: PNT_INCOME_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    收益日志ID
     *
     *    数据库字段: PNT_INCOME_LOG.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_INCOME_LOG.ACCOUNT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_INCOME_LOG.ACCOUNT_ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
     *    收益日志类型(1: 日收益； 2: 转出收益)
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_LOG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Byte getIncomeLogType() {
        return incomeLogType;
    }

    /**
     *    收益日志类型(1: 日收益； 2: 转出收益)
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_LOG_TYPE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIncomeLogType(Byte incomeLogType) {
        this.incomeLogType = incomeLogType;
    }

    /**
     *    改变前的收益
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_BEFORE_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getIncomeBeforeChanged() {
        return incomeBeforeChanged;
    }

    /**
     *    改变前的收益
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_BEFORE_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIncomeBeforeChanged(BigDecimal incomeBeforeChanged) {
        this.incomeBeforeChanged = incomeBeforeChanged;
    }

    /**
     *    改变的收益
     *
     *    数据库字段: PNT_INCOME_LOG.CHANGED_INCOME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getChangedIncome() {
        return changedIncome;
    }

    /**
     *    改变的收益
     *
     *    数据库字段: PNT_INCOME_LOG.CHANGED_INCOME
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setChangedIncome(BigDecimal changedIncome) {
        this.changedIncome = changedIncome;
    }

    /**
     *    改变后的收益(改变后的收益=改变前的收益+改变的收益)
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_AFTER_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public BigDecimal getIncomeAfterChanged() {
        return incomeAfterChanged;
    }

    /**
     *    改变后的收益(改变后的收益=改变前的收益+改变的收益)
     *
     *    数据库字段: PNT_INCOME_LOG.INCOME_AFTER_CHANGED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIncomeAfterChanged(BigDecimal incomeAfterChanged) {
        this.incomeAfterChanged = incomeAfterChanged;
    }

    /**
     *    改变收益的标题
     *
     *    数据库字段: PNT_INCOME_LOG.CHANGED_TITILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public String getChangedTitile() {
        return changedTitile;
    }

    /**
     *    改变收益的标题
     *
     *    数据库字段: PNT_INCOME_LOG.CHANGED_TITILE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setChangedTitile(String changedTitile) {
        this.changedTitile = changedTitile;
    }

    /**
     *    统计日期(日收益的日期)
     *
     *    数据库字段: PNT_INCOME_LOG.STAT_DATE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Date getStatDate() {
        return statDate;
    }

    /**
     *    统计日期(日收益的日期)
     *
     *    数据库字段: PNT_INCOME_LOG.STAT_DATE
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    /**
     *    修改时间戳
     *
     *    数据库字段: PNT_INCOME_LOG.MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
     *    修改时间戳
     *
     *    数据库字段: PNT_INCOME_LOG.MODIFIED_TIMESTAMP
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setModifiedTimestamp(Long modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
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
        sb.append(", incomeLogType=").append(incomeLogType);
        sb.append(", incomeBeforeChanged=").append(incomeBeforeChanged);
        sb.append(", changedIncome=").append(changedIncome);
        sb.append(", incomeAfterChanged=").append(incomeAfterChanged);
        sb.append(", changedTitile=").append(changedTitile);
        sb.append(", statDate=").append(statDate);
        sb.append(", modifiedTimestamp=").append(modifiedTimestamp);
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
        PntIncomeLogMo other = (PntIncomeLogMo) that;
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
