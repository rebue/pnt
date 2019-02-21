package rebue.pnt.mapper;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.to.ModifyIncomeTo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntAccountMapper extends MybatisBaseMapper<PntAccountMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntAccountMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntAccountMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntAccountMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntAccountMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntAccountMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntAccountMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntAccountMo> selectSelective(PntAccountMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntAccountMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntAccountMo record);

    /**
     * 获取需要计算日收益的账户列表
     *
     * @param fetchCount
     *            获取结果限制数量
     */
    @// 
    Select(// 
    "SELECT " + // 
    "    ID, DAY_INCOME_STAT_DATE, REG_TIME  " + // 
    " FROM" + // 
    "    PNT_ACCOUNT  " + " WHERE" + "    (DAY_INCOME_STAT_DATE IS NULL" + 
    "        OR DAY_INCOME_STAT_DATE < #{yesterday,jdbcType=DATE}) " + 
    " and REG_TIME < #{yesterdayRegTime,jdbcType=TIMESTAMP} " + 
    " LIMIT #{fetchCount}")
    List<PntAccountMo> listToCalcDayIncome(@Param("yesterday") java.sql.Date yesterday, @Param("fetchCount") int fetchCount, @Param("yesterdayRegTime") java.util.Date yesterdayRegTime);

    /**
     * 修改积分账号信息
     *
     * @param id
     *            账号id
     * @param newPoints
     *            新的当前积分
     * @param oldPoints
     *            旧的当前积分
     * @param newModifiedTimestamp
     *            新的修改时间戳
     * @param oldModifiedTimestamp
     *            旧的修改时间戳
     * @return
     */
    @Update("update PNT_ACCOUNT set POINT=#{newPoint,jdbcType=DECIMAL}, MODIFIED_TIMESTAMP=#{newModifiedTimestamp,jdbcType=BIGINT} where ID=#{id,jdbcType=BIGINT} and POINT=#{oldPoint,jdbcType=DECIMAL} and MODIFIED_TIMESTAMP=#{oldModifiedTimestamp,jdbcType=BIGINT}")
    int updatePoint(@Param("id") Long id, @Param("newPoint") BigDecimal newPoint, @Param("oldPoint") BigDecimal oldPoint, @Param("newModifiedTimestamp") Long newModifiedTimestamp, @Param("oldModifiedTimestamp") Long oldModifiedTimestamp);

    /**
     * 修改收益
     * @return
     */
    int updateIncome(ModifyIncomeTo to);
    
    /**
     * 根据限制的条数查询积分账号信息
     * @param limitCount
     * @return
     */
    @Select("SELECT * FROM pnt.PNT_ACCOUNT limit #{pageNum,jdbcType=INTEGER}, #{limitCount,jdbcType=INTEGER}")
    List<PntAccountMo> selectPntAccountByLimitCount(@Param("pageNum") Integer pageNum, @Param("limitCount") Integer limitCount);
}
