package rebue.pnt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.pnt.mo.PntFlowMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntFlowMapper extends MybatisBaseMapper<PntFlowMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntFlowMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntFlowMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntFlowMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntFlowMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntFlowMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntFlowMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntFlowMo> selectSelective(PntFlowMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntFlowMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntFlowMo record);
}