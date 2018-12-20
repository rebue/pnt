package rebue.pnt.to;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 修改积分账号信息请求参数
 * @author lbl
 * 2018年12月19日17:17:17
 */
@Data
public class ModifyPointAccountTo {

	/**
	 * 账号id
	 */
	private Long accountId;
	
	/**
	 * 新的当前积分
	 */
	private BigDecimal newPoints;
	
	/**
	 * 旧的当前积分
	 */
	private BigDecimal oldPoints;
	
	/**
	 * 新修改时间戳
	 */
	private Long newModifiedTimestamp;
	
	/**
	 * 旧修改时间戳
	 */
	private Long oldModifiedTimestamp;
}
