package rebue.pnt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.pnt.mo.PntLogTypeMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntLogTypeMapper extends MybatisBaseMapper<PntLogTypeMo, Long> {
    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntLogTypeMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntLogTypeMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntLogTypeMo selectByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntLogTypeMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntLogTypeMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntLogTypeMo> selectAll();

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntLogTypeMo> selectSelective(PntLogTypeMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(Long id);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntLogTypeMo record);

    /**
    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntLogTypeMo record);
}