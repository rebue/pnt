package rebue.pnt.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import rebue.pnt.mo.PntAccountMo;
import rebue.robotech.mapper.MybatisBaseMapper;

@Mapper
public interface PntAccountMapper extends MybatisBaseMapper<PntAccountMo, Long> {

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	int insert(PntAccountMo record);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	int insertSelective(PntAccountMo record);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	PntAccountMo selectByPrimaryKey(Long id);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	int updateByPrimaryKeySelective(PntAccountMo record);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	int updateByPrimaryKey(PntAccountMo record);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	List<PntAccountMo> selectAll();

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	List<PntAccountMo> selectSelective(PntAccountMo record);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	boolean existByPrimaryKey(Long id);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	boolean existSelective(PntAccountMo record);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	int countSelective(PntAccountMo record);

	/**
	 * 修改积分账号信息
	 * 
	 * @param id                   账号id
	 * @param newPoints            新的当前积分
	 * @param oldPoints            旧的当前积分
	 * @param newModifiedTimestamp 新的修改时间戳
	 * @param oldModifiedTimestamp 旧的修改时间戳
	 * @return
	 */
	@Update("update PNT_ACCOUNT set POINTS=#{newPoints,jdbcType=BIGINT}, MODIFIED_TIMESTAMP=#{newModifiedTimestamp,jdbcType=BIGINT} where ID=#{id,jdbcType=BIGINT} and POINTS=#{oldPoints,jdbcType=BIGINT} and MODIFIED_TIMESTAMP=#{oldModifiedTimestamp,jdbcType=BIGINT}")
	int modifyAccount(@Param("id") Long id, @Param("newPoints") Long newPoints, @Param("oldPoints") Long oldPoints,
			@Param("newModifiedTimestamp") Long newModifiedTimestamp,
			@Param("oldModifiedTimestamp") Long oldModifiedTimestamp);
}
