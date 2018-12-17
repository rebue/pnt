package rebue.pnt.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
积分账户流水(将账户每一次积分变更作个记录)

数据库表: PNT_FLOW

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class PntFlowMo implements Serializable {
    /**
    流水ID(等于日志ID)
    
    数据库字段: PNT_FLOW.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    积分账户ID(等于SUC的用户ID)
    
    数据库字段: PNT_FLOW.ACCOUNT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long accountId;

    /**
    当前积分数量
    
    数据库字段: PNT_FLOW.POINTS
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long points;

    /**
    旧修改时间戳
    
    数据库字段: PNT_FLOW.OLD_MODIFIED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long oldModifiedTimestamp;

    /**
    修改时间戳(添加或更新本条记录时的时间戳)
    
    数据库字段: PNT_FLOW.MODIFIED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long modifiedTimestamp;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    流水ID(等于日志ID)
    
    数据库字段: PNT_FLOW.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    流水ID(等于日志ID)
    
    数据库字段: PNT_FLOW.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    积分账户ID(等于SUC的用户ID)
    
    数据库字段: PNT_FLOW.ACCOUNT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getAccountId() {
        return accountId;
    }

    /**
    积分账户ID(等于SUC的用户ID)
    
    数据库字段: PNT_FLOW.ACCOUNT_ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    /**
    当前积分数量
    
    数据库字段: PNT_FLOW.POINTS
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getPoints() {
        return points;
    }

    /**
    当前积分数量
    
    数据库字段: PNT_FLOW.POINTS
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setPoints(Long points) {
        this.points = points;
    }

    /**
    旧修改时间戳
    
    数据库字段: PNT_FLOW.OLD_MODIFIED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getOldModifiedTimestamp() {
        return oldModifiedTimestamp;
    }

    /**
    旧修改时间戳
    
    数据库字段: PNT_FLOW.OLD_MODIFIED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setOldModifiedTimestamp(Long oldModifiedTimestamp) {
        this.oldModifiedTimestamp = oldModifiedTimestamp;
    }

    /**
    修改时间戳(添加或更新本条记录时的时间戳)
    
    数据库字段: PNT_FLOW.MODIFIED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getModifiedTimestamp() {
        return modifiedTimestamp;
    }

    /**
    修改时间戳(添加或更新本条记录时的时间戳)
    
    数据库字段: PNT_FLOW.MODIFIED_TIMESTAMP
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setModifiedTimestamp(Long modifiedTimestamp) {
        this.modifiedTimestamp = modifiedTimestamp;
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
        sb.append(", points=").append(points);
        sb.append(", oldModifiedTimestamp=").append(oldModifiedTimestamp);
        sb.append(", modifiedTimestamp=").append(modifiedTimestamp);
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
        PntFlowMo other = (PntFlowMo) that;
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