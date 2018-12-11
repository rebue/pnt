package rebue.pnt.mo;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/**
积分日志类型

数据库表: PNT_LOG_TYPE

@mbg.generated 自动生成的注释，如需修改本注释，请删除本行
*/
@JsonInclude(Include.NON_NULL)
public class PntLogTypeMo implements Serializable {
    /**
    积分日志类型ID
    
    数据库字段: PNT_LOG_TYPE.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private Long id;

    /**
    积分日志类型编码
    
    数据库字段: PNT_LOG_TYPE.TYPE_CODE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String typeCode;

    /**
    积分日志类型名称
    
    数据库字段: PNT_LOG_TYPE.TYPE_NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String typeName;

    /**
    积分日志类型备注
    
    数据库字段: PNT_LOG_TYPE.REMARK
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    private String remark;

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
    积分日志类型ID
    
    数据库字段: PNT_LOG_TYPE.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public Long getId() {
        return id;
    }

    /**
    积分日志类型ID
    
    数据库字段: PNT_LOG_TYPE.ID
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    积分日志类型编码
    
    数据库字段: PNT_LOG_TYPE.TYPE_CODE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getTypeCode() {
        return typeCode;
    }

    /**
    积分日志类型编码
    
    数据库字段: PNT_LOG_TYPE.TYPE_CODE
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    /**
    积分日志类型名称
    
    数据库字段: PNT_LOG_TYPE.TYPE_NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getTypeName() {
        return typeName;
    }

    /**
    积分日志类型名称
    
    数据库字段: PNT_LOG_TYPE.TYPE_NAME
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
    积分日志类型备注
    
    数据库字段: PNT_LOG_TYPE.REMARK
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public String getRemark() {
        return remark;
    }

    /**
    积分日志类型备注
    
    数据库字段: PNT_LOG_TYPE.REMARK
    
    @mbg.generated 自动生成，如需修改，请删除本行
    */
    public void setRemark(String remark) {
        this.remark = remark;
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
        sb.append(", typeCode=").append(typeCode);
        sb.append(", typeName=").append(typeName);
        sb.append(", remark=").append(remark);
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
        PntLogTypeMo other = (PntLogTypeMo) that;
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