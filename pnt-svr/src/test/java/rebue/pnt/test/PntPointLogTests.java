package rebue.pnt.test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import rebue.ord.mo.OrdOrderMo;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.mo.PntPointLogMo;
import rebue.pnt.to.AddPointTradeTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;
import rebue.wheel.OkhttpUtils;
import rebue.wheel.RandomEx;
import rebue.wheel.idworker.IdWorker3;

/**
 * 积分日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public class PntPointLogTests {
	private final static Logger _log = LoggerFactory.getLogger(PntPointLogTests.class);
	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	private final ObjectMapper _objectMapper = new ObjectMapper();

	// @Test
	public void testCrud() throws IOException, ReflectiveOperationException {
		PntPointLogMo mo = null;
		for (int i = 0; i < 20; i++) {
			mo = (PntPointLogMo) RandomEx.randomPojo(PntPointLogMo.class);
			mo.setId(null);
			System.out.println("添加积分日志的参数为：" + mo);
			final String addResult = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointlog", mo);
			System.out.println("添加积分日志的返回值为：" + addResult);
			final IdRo idRo = _objectMapper.readValue(addResult, IdRo.class);
			System.out.println(idRo);
			Assert.assertEquals(ResultDic.SUCCESS, idRo.getResult());
			mo.setId(Long.valueOf(idRo.getId()));
		}
		final String listResult = OkhttpUtils.get(hostUrl + "/pnt/pointlog?pageNum=1&pageSize=5");
		System.out.println("查询积分日志的返回值为：" + listResult);
		System.out.println("获取单个积分日志的参数为：" + mo.getId());
		final String getByIdResult = OkhttpUtils.get(hostUrl + "/pnt/pointlog/getbyid?id=" + mo.getId());
		System.out.println("获取单个积分日志的返回值为：" + getByIdResult);
		System.out.println("修改积分日志的参数为：" + mo);
		final String modifyResult = OkhttpUtils.putByJsonParams(hostUrl + "/pnt/pointlog", mo);
		System.out.println("修改积分日志类型的返回值为：" + modifyResult);
		final Ro modifyRo = _objectMapper.readValue(modifyResult, Ro.class);
		System.out.println(modifyRo);
		Assert.assertEquals(ResultDic.SUCCESS, modifyRo.getResult());
		System.out.println("删除积分日志的参数为：" + mo.getId());
		final String deleteResult = OkhttpUtils.delete(hostUrl + "/pnt/pointlog?id=" + mo.getId());
		System.out.println("删除积分日志的返回值为：" + deleteResult);
		final Ro deleteRo = _objectMapper.readValue(deleteResult, Ro.class);
		System.out.println(deleteRo);
		Assert.assertEquals(ResultDic.SUCCESS, deleteRo.getResult());
	}

	private final String hostUrl = "http://127.0.0.1:9010";

	// @Test
	public void addPointTest() throws IOException {
		AddPointTradeTo to = new AddPointTradeTo();
		to.setAccountId(520391209198288896L);
		to.setPointLogType((byte) 1);
		to.setChangedTitile("大卖网络-购买商品添加积分");
		to.setChangedDetail("测试商品");
		to.setOrderId(123456456710L);
		to.setOrderDetailId(7894561237L);
		to.setChangedPoint(BigDecimal.valueOf(6));
		final String results = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointtrade", to);
		System.out.println(results);
		to = new AddPointTradeTo();
		to.setAccountId(520391209198288896L);
		to.setPointLogType((byte) 2);
		to.setChangedTitile("大卖网络-商品退货扣减积分");
		to.setChangedDetail("测试商品");
		to.setOrderId(123456456710L);
		to.setOrderDetailId(7894561237L);
		to.setChangedPoint(BigDecimal.valueOf(2));
		final String resultss = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointtrade", to);
		System.out.println(resultss);
		to = new AddPointTradeTo();
		to.setAccountId(520391209198288896L);
		to.setPointLogType((byte) 3);
		to.setChangedTitile("大卖网络-v支付提现扣减积分");
		to.setOrderId(123456456711L);
		to.setChangedPoint(BigDecimal.valueOf(2));
		final String resultsss = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointtrade", to);
		System.out.println(resultsss);
	}

	// @Test
	public void test001() throws IOException {
		String listAll = OkhttpUtils.get(hostUrl + "/pnt/account/all");
		List<Map<String, Object>> lists = _objectMapper.readValue(listAll, List.class);
		IdWorker3 idWorker3 = new IdWorker3();
		for (int i = 0; i < lists.size(); i++) {
			AddPointTradeTo to = new AddPointTradeTo();
			to.setAccountId(Long.parseLong(String.valueOf(lists.get(i).get("id"))));
			to.setPointLogType((byte) 5);
			to.setChangedTitile("大卖网络-新用户奖励积分");
			to.setOrderId(idWorker3.getId());
			to.setChangedPoint(BigDecimal.valueOf(10));
			final String results = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointtrade", to);
			System.out.println(results);
		}
	}

	// @Test
	public void test0002() {
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_YEAR, -90);
		Date date1 = calendar.getTime();
		System.out.println(date1);

		calendar.setTime(now);
		calendar.add(Calendar.DAY_OF_YEAR, -60);
		Date date2 = calendar.getTime();
		System.out.println(date2);

		System.out.println(date1.compareTo(date2));
	}

	@Test
	public void countByIdAndOrderIdTest() throws IOException {
		PntPointLogMo mo = new PntPointLogMo();
		mo.setAccountId(560723287034822657L);
		mo.setPointLogType((byte) 3);
		mo.setOrderId(562075656935047168L);
		final String results = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointlog/countByIdAndOrderId", mo);
		System.out.println(results);
	}

	/**
	 * 设置大概正确的积分(扣除类型是7，8，9)扣除时间戳 因为原来扣除积分出现bug每个类型扣除过一次之后就不会再扣除该类型的或者
	 * 是直接扣除8,9，类型的，所以这里根据最后的签收时间(2019-6-4后是支付时间)
	 * 来推断出大概的扣除时间是不一定准确的，注意！！这里面有想路径映射是写的时候临时写进去的 ，修正时间后就删除了，所以直接运行发出某些请求是不存在的。
	 * 
	 * @throws IOException
	 */
	@Test
	public void setCorrectTime() throws IOException {

		// 1：在积分获取所有账户，再根据帐号id获取账户最后一个订单签收的时间，如果没有的话就获取用户在积分里面的注册时间
		PntAccountMo[] pntAccountResult = _objectMapper.readValue(OkhttpUtils.get(hostUrl + "/pnt/account/all"),
				PntAccountMo[].class);
		_log.info("所有积分账户信息: {}", pntAccountResult.toString());

		// 遍历每个积分账户信息去获取最新的订单签收时间
		for (PntAccountMo PntAccountMo : pntAccountResult) {
			_log.info("开始-----------------------------------------------");

			_log.info("当前积分账户信息: {}", PntAccountMo);
			OrdOrderMo[] orderResult = _objectMapper.readValue(
					OkhttpUtils.get("http://127.0.0.1:20180/ord/order/listselective?userId=" + PntAccountMo.getId()),
					OrdOrderMo[].class);
			_log.info("获取最新订单信息的结果长度为 : orderResult.length-{}", orderResult.length);

			// 判断长度是否为0,如果是0的话那么用户没有买过商品，对比时间使用用户的在积分中的注册时间，否则就取签收时间，(注意！！！)测试的时候将
			// 获取订单的方法设置成了根据签收时间排序且只返回第一个结果，虽然是个数组但是只有一个元素
			// 最后购买或者是注册时间戳
			Long time = 0L;
			if (orderResult.length == 0) {
				if (PntAccountMo.getRegTime() != null) {
					_log.info("取注册时间-{} ", PntAccountMo.getRegTime().getTime());
					time = PntAccountMo.getRegTime().getTime();
				}
				_log.info("注册时间time-{}", time);
			} else {
				for (OrdOrderMo ordOrderMo : orderResult) {
					if (ordOrderMo.getReceivedTime() != null) {
						_log.info("取签收时间-{}", ordOrderMo.getReceivedTime().getTime());
						time = ordOrderMo.getReceivedTime().getTime();
					}
					_log.info("取签收时间time-{}", time);
				}
			}

			// 如果签收或者注册时间小于三十天就终止本次循环
			if (new Date().getTime() - time < 2592000000l) {
				_log.info("小于三十天：{}-{}={}", new Date().getTime(), time, new Date().getTime() - time);
				continue;
			} else {
				_log.info("大于三十天：{}-{}={}", new Date().getTime(), time, new Date().getTime() - time);
			}

			// 获取积分日志的三种类型扣除记录，
			PntPointLogMo[] pntLogResult = _objectMapper.readValue(
					OkhttpUtils.get(hostUrl + "/pnt/pointlog/selectList?accountId=" + PntAccountMo.getId()),
					PntPointLogMo[].class);
			_log.info("获取积分日志的三种类型扣除记录长度为 : pntLogResult.length-{}", pntLogResult.length);
			for (PntPointLogMo pntPointLogMo : pntLogResult) {
				// 先判断是否是正确的时间戳格式(小于当前时间)如果是就终止修改
				if (pntPointLogMo.getModifiedTimestamp() < 1559616795104l) {
					continue;
				}
				Long newTime = time;
				_log.info("当前扣除积分类型pntPointLogMo-{}", pntPointLogMo);

				// 如果类型是7则time加上 259200000 一个月后的时间戳
				if (pntPointLogMo.getPointLogType() == 7) {
					newTime += 2592000000l;
					_log.info("一个月 newTime-{}", newTime);
				}
				// 如果类型是7则time加上 5184000000 二个月后的时间戳
				if (pntPointLogMo.getPointLogType() == 8 && new Date().getTime() - time > 5184000000L) {
					newTime += 5184000000L;
					_log.info("二个月 newTime-{}", newTime);
				}
				// 如果类型是7则time加上 7776000000 三个月后的时间戳
				if (pntPointLogMo.getPointLogType() == 9 && new Date().getTime() - time > 7776000000L) {
					newTime += 7776000000L;
					_log.info("三个月 newTime-{}", newTime);
				}

				// 改变积分日志的时间。
				PntPointLogMo modifyPntPointLogMo = new PntPointLogMo();
				modifyPntPointLogMo.setId(pntPointLogMo.getId());
				modifyPntPointLogMo.setModifiedTimestamp(newTime);
				_log.info("更新积分日志时间戳的参数为：pntPointLogMo-{}", modifyPntPointLogMo);

				final String result = OkhttpUtils.putByJsonParams(hostUrl + "/pnt/pointlog", modifyPntPointLogMo);
				_log.info("更新积分日志时间戳的结果为：result-{}", result);
				newTime = time;
			}
			_log.info("结束++++++++++++++++++++++++++++++++++++++");
		}
	}

}
