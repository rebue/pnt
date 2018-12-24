package rebue.pnt.util;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 积分算法工具类
 * @author lbl
 * 2018年12月21日10:07:37
 */
public class PntPointAlgorithmUtils {

	private static final Logger _log = LoggerFactory.getLogger(PntPointAlgorithmUtils.class);
	
	/**
	 * 返佣积分算法（非首单） = 销售价 / 2 - 成本价
	 * @param salePrice 销售价
	 * @param costPrice 成本价
	 * @return
	 */
	public static BigDecimal commissionPoint(BigDecimal salePrice, BigDecimal costPrice) {
		_log.info("计算积分的参数为：salePrice={}, costPrice={}", salePrice, costPrice);
		BigDecimal point = salePrice.divide(BigDecimal.valueOf(2)).subtract(costPrice);
		_log.info("计算积分的返回值为：{}", point);
		return point;
	}
	
	/**
	 * 首单积分算法 = 销售价 * 0.5(或50%)
	 * @param salePrice 销售价
	 * @return
	 */
	public static BigDecimal firstOrderPoint(BigDecimal salePrice) {
		_log.info("计算首单积分的参数为：salePrice={}", salePrice);
		BigDecimal point = salePrice.multiply(BigDecimal.valueOf(0.5));
		_log.info("计算首单积分的返回值为：{}", point);
		return point;
	}
}
