package rebue.pnt.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import rebue.pnt.mo.PntAccountMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntAccountMapper extends MybatisBaseMapper<PntAccountMo, Long> {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(PntAccountMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(PntAccountMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    PntAccountMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(PntAccountMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(PntAccountMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<PntAccountMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<PntAccountMo> selectSelective(PntAccountMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(PntAccountMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntAccountMo record);

    /**
     * 获取需要计算日收益的账户列表
     * 
     * @param fetchCount
     *            获取结果限制数量
     */
    @Select("SELECT " + //
            "    ID, DAY_INCOME_STAT_DATE" + //
            "FROM" + //
            "    PNT_ACCOUNT" + //
            "WHERE" + //
            "    DAY_INCOME_STAT_DATE IS NULL" + //
            "        OR DAY_INCOME_STAT_DATE < #{yesterday,jdbcType=DATE}" + //
            "LIMIT #{fetchCount}")
    List<PntAccountMo> listToCalcDayIncome(@Param("yesterday") java.sql.Date yesterday, @Param("fetchCount") int fetchCount);

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
    int updatePoint(@Param("id") Long id, @Param("newPoint") BigDecimal newPoint, @Param("oldPoint") BigDecimal oldPoint, @Param("newModifiedTimestamp") Long newModifiedTimestamp,
            @Param("oldModifiedTimestamp") Long oldModifiedTimestamp);

    /**
     * @param id
     *            账号id
     * @param newIncome
     *            新的收益
     * @param oldIncome
     *            旧的收益
     * @param newTotalIncome
     *            新的总收益
     * @param oldTotalIncome
     *            旧的总收益
     * @param newModifiedTimestamp
     *            新的修改时间戳
     * @param oldModifiedTimestamp
     *            旧的修改时间戳
     * @return
     */
    @Update("update PNT_ACCOUNT set INCOME=#{newIncome,jdbcType=DECIMAL}, TOTAL_INCOME=#{newTotalIncome,jdbcType=DECIMAL}, MODIFIED_TIMESTAMP=#{newModifiedTimestamp,jdbcType=BIGINT}, DAY_INCOME_STAT_DATE = #{dayIncomeStatDate,jdbcType=DATE} where ID=#{id,jdbcType=BIGINT} and INCOME=#{oldIncome,jdbcType=DECIMAL} and TOTAL_INCOME=#{oldTotalIncome,jdbcType=DECIMAL} and MODIFIED_TIMESTAMP=#{oldModifiedTimestamp,jdbcType=BIGINT}")
    int updateIncome(@Param("id") Long id, @Param("newIncome") BigDecimal newIncome, @Param("oldIncome") BigDecimal oldIncome, @Param("newTotalIncome") BigDecimal newTotalIncome,
            @Param("oldTotalIncome") BigDecimal oldTotalIncome, @Param("newModifiedTimestamp") Long newModifiedTimestamp, @Param("oldModifiedTimestamp") Long oldModifiedTimestamp,
            @Param("dayIncomeStatDate") Date dayIncomeStatDate);

}
