package rebue.pnt.mo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

/**
 * 积分账户信息
 *
 * 数据库表: PNT_ACCOUNT
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@JsonInclude(Include.NON_NULL)
public class PntAccountMo implements Serializable {

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_ACCOUNT.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long id;

    /**
     *    当前积分数量
     *
     *    数据库字段: PNT_ACCOUNT.POINTS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Long points;

    /**
     *    是否锁定
     *
     *    数据库字段: PNT_ACCOUNT.IS_LOCKED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private Boolean isLocked;

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final long serialVersionUID = 1L;

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_ACCOUNT.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getId() {
        return id;
    }

    /**
     *    积分账户ID(等于SUC的用户ID)
     *
     *    数据库字段: PNT_ACCOUNT.ID
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *    当前积分数量
     *
     *    数据库字段: PNT_ACCOUNT.POINTS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Long getPoints() {
        return points;
    }

    /**
     *    当前积分数量
     *
     *    数据库字段: PNT_ACCOUNT.POINTS
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setPoints(Long points) {
        this.points = points;
    }

    /**
     *    是否锁定
     *
     *    数据库字段: PNT_ACCOUNT.IS_LOCKED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public Boolean getIsLocked() {
        return isLocked;
    }

    /**
     *    是否锁定
     *
     *    数据库字段: PNT_ACCOUNT.IS_LOCKED
     *
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
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
        sb.append(", points=").append(points);
        sb.append(", isLocked=").append(isLocked);
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
        PntAccountMo other = (PntAccountMo) that;
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
