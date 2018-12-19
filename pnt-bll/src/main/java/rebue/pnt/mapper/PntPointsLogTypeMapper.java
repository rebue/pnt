package rebue.pnt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import rebue.pnt.mo.PntPointsLogTypeMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntPointsLogTypeMapper extends MybatisBaseMapper<PntPointsLogTypeMo, String> {

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int deleteByPrimaryKey(String id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insert(PntPointsLogTypeMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int insertSelective(PntPointsLogTypeMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    PntPointsLogTypeMo selectByPrimaryKey(String id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKeySelective(PntPointsLogTypeMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int updateByPrimaryKey(PntPointsLogTypeMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntPointsLogTypeMo> selectAll();

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    List<PntPointsLogTypeMo> selectSelective(PntPointsLogTypeMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existByPrimaryKey(String id);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    boolean existSelective(PntPointsLogTypeMo record);

    /**
     *    @mbg.generated 自动生成，如需修改，请删除本行
     */
    int countSelective(PntPointsLogTypeMo record);
}
