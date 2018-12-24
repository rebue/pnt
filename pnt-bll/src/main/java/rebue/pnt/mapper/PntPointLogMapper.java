package rebue.pnt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.pnt.mo.PntPointLogMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntPointLogMapper extends MybatisBaseMapper<PntPointLogMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntPointLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntPointLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntPointLogMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntPointLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntPointLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntPointLogMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntPointLogMo> selectSelective(PntPointLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntPointLogMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntPointLogMo record);
}