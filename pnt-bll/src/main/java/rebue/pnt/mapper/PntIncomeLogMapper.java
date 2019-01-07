package rebue.pnt.mapper;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.pnt.mo.PntIncomeLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntIncomeLogMapper extends MybatisBaseMapper<PntIncomeLogMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntIncomeLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntIncomeLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntIncomeLogMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntIncomeLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntIncomeLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntIncomeLogMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntIncomeLogMo> selectSelective(PntIncomeLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntIncomeLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntIncomeLogMo record);
    
    /**
     * 统计收益（目前只统计昨日收益，以后可调整为统计多天的收益）
     * @param accountId
     * @return
     */
    BigDecimal countYesterdayIncome(Long accountId);
}
