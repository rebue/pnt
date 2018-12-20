package rebue.pnt.to;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * 添加收益交易请求参数
 * 
 * @author lbl
 * @version 1.0.9 2018年12月20日10:05:10
 */
@Data
public class AddIncomeTradeTo {

	/**
	 * 积分账户ID(等于SUC的用户ID)
	 *
	 * 数据库字段: PNT_INCOME_LOG.ACCOUNT_ID
	 */
	private Long accountId;

	/**
	 * 收益日志类型(1: 日收益； 2: 转出收益)
	 *
	 * 数据库字段: PNT_INCOME_LOG.INCOME_LOG_TYPE
	 */
	private Byte incomeLogType;

	/**
	 * 改变的收益
	 *
	 * 数据库字段: PNT_INCOME_LOG.CHANGED_INCOME
	 */
	private BigDecimal changedIncome;

	/**
	 * 改变收益的标题
	 *
	 * 数据库字段: PNT_INCOME_LOG.CHANGED_TITILE
	 */
	private String changedTitile;

	/**
	 * 改变收益的详情
	 *
	 * 数据库字段: PNT_INCOME_LOG.CHANGED_DETAIL
	 */
	private String changedDetail;

	/**
	 * 统计日期(日收益的日期)
	 *
	 * 数据库字段: PNT_INCOME_LOG.STAT_DATE
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date statDate;

	/**
	 * 修改时间戳
	 *
	 * 数据库字段: PNT_INCOME_LOG.MODIFIED_TIMESTAMP
	 */
	private Long modifiedTimestamp;
}
