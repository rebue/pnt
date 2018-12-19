package rebue.pnt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.pnt.mo.PntPointsLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntPointsLogMapper extends MybatisBaseMapper<PntPointsLogMo, Long> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntPointsLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntPointsLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntPointsLogMo selectByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntPointsLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntPointsLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntPointsLogMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntPointsLogMo> selectSelective(PntPointsLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntPointsLogMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntPointsLogMo record);
}
