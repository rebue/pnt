package rebue.pnt.to;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 修改收益的参数信息
 * 
 * @author lbl 2018年12月20日15:59:51
 */
@Data
public class ModifyIncomeTo {

	/**
	 * 账号ID
	 */
	private Long accountId;

	/**
	 * 新的当前收益
	 */
	private BigDecimal newIncome;

	/**
	 * 旧的当前收益
	 */
	private BigDecimal oldIncome;

	/**
	 * 新的历史总收益
	 */
	private BigDecimal newTotalIncome;

	/**
	 * 旧的历史总收益
	 */
	private BigDecimal oldTotalIncome;

	/**
	 * 新修改时间戳
	 */
	private Long newModifiedTimestamp;

	/**
	 * 旧修改时间戳
	 */
	private Long oldModifiedTimestamp;

	/**
	 * 日收益统计日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date dayIncomeStatDate;
}
