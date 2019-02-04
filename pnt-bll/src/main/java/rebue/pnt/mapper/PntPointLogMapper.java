package rebue.pnt.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import rebue.pnt.mo.PntPointLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntPointLogMapper extends MybatisBaseMapper<PntPointLogMo, Long> {
    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int deleteByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insert(PntPointLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int insertSelective(PntPointLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    PntPointLogMo selectByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKeySelective(PntPointLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    int updateByPrimaryKey(PntPointLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<PntPointLogMo> selectAll();

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    List<PntPointLogMo> selectSelective(PntPointLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existByPrimaryKey(Long id);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    boolean existSelective(PntPointLogMo record);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntPointLogMo record);

    /**
     * 根据用户id查询积分日志
     * 
     * @param id
     * @return
     */
    @Select("SELECT * FROM PNT_POINT_LOG where account_id =#{accountId,jdbcType=BIGINT} order by modified_timestamp")
    List<PntPointLogMo> listByAccountId(@Param("accountId") Long accountId);

    /**
     * 根据账号id获取昨天最后一个修改后的积分
     * 
     * @param accountId
     * @return
     */
    BigDecimal selectPointAfterChangedByAccountId(Long accountId);

    /**
     * 获取账户某一天的积分
     * 
     * @param accountId
     *            积分账户ID
     * @param statDateTimestamp
     *            指定某一天+24小时的时间戳
     * @return 获取账户某一天的积分
     */
    @Select("SELECT " + //
            "    POINT_AFTER_CHANGED" + //
            " FROM" + //
            "    pnt.PNT_POINT_LOG" + //
            " WHERE" + //
            "    ACCOUNT_ID = #{accountId}" + //
            "        AND MODIFIED_TIMESTAMP < #{statDateTimestamp}" + //
            " ORDER BY MODIFIED_TIMESTAMP DESC" + //
            " LIMIT 1")
    BigDecimal getPointsOfDate(@Param("accountId") Long accountId, @Param("statDateTimestamp") Long statDateTimestamp);

    /**
     * 根据账号id查询最新的一条
     * @param accountId
     * @return
     */
    @Select("select * from PNT_POINT_LOG where ACCOUNT_ID=#{accountId,jdbcType=BIGINT} order by MODIFIED_TIMESTAMP desc limit 1")
    PntPointLogMo selectNewOne(Long accountId);
}