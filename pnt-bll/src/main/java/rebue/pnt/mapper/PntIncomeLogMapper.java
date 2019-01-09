package rebue.pnt.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import rebue.pnt.dic.IncomeLogTypeDic;
import rebue.pnt.mo.PntIncomeLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntIncomeLogMapper extends MybatisBaseMapper<PntIncomeLogMo, Long> {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(PntIncomeLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(PntIncomeLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    PntIncomeLogMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(PntIncomeLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(PntIncomeLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<PntIncomeLogMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<PntIncomeLogMo> selectSelective(PntIncomeLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(PntIncomeLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntIncomeLogMo record);

    /**
     * 统计某日收益（目前只有获取昨日收益使用）
     * 
     * @param accountId
     *            用户积分账户
     * @param statDate
     *            获取收益的指定日期
     * @param dateIncomeType
     *            日收益日志类型
     * @return 指定日期的收益
     */
    @Select("SELECT " + //
            "        CHANGED_INCOME AS changeIncomeTotal" + //
            "    FROM" + //
            "        pnt.PNT_INCOME_LOG" + //
            "    WHERE" + //
            "        ACCOUNT_ID = #{accountId,jdbcType=BIGINT}" + //
            "            AND STAT_DATE = #{statDate,jdbcType=DATE}" + //
            "            AND INCOME_LOG_TYPE = #{dateIncomeType}")
    BigDecimal getIncomeOfDate(@Param("accountId") Long accountId, @Param("statDate") java.sql.Date statDate, @Param("dateIncomeType") IncomeLogTypeDic dateIncomeType);
}
