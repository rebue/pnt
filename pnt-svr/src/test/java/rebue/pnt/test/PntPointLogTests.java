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

//    @Test
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

//	@Test
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
	
	//@Test
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
		PntPointLogMo mo =new PntPointLogMo();
		mo.setAccountId(560723287034822657L);
		mo.setPointLogType((byte)3);
		mo.setOrderId(562075656935047168L);
		final String results = OkhttpUtils.postByJsonParams(hostUrl+ "/pnt/pointlog/countByIdAndOrderId",mo);
		System.out.println(results);
	}
}
