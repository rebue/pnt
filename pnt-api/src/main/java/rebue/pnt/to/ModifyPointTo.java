package rebue.pnt.to;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 修改积分信息请求参数
 * @author lbl
 * 2018年12月19日17:17:17
 */
@Data
public class ModifyPointTo {

	/**
	 * 账号id
	 */
	private Long accountId;
	
	/**
	 * 新的当前积分
	 */
	private BigDecimal newPoint;
	
	/**
	 * 旧的当前积分
	 */
	private BigDecimal oldPoint;
	
	/**
	 * 新修改时间戳
	 */
	private Long newModifiedTimestamp;
	
	/**
	 * 旧修改时间戳
	 */
	private Long oldModifiedTimestamp;
}
