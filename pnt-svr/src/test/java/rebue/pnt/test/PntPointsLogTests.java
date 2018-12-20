package rebue.pnt.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import rebue.pnt.dic.PointLogTypeDic;
import rebue.pnt.mo.PntPointsLogMo;
import rebue.pnt.to.AddPointTradeTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;
import rebue.wheel.OkhttpUtils;
import rebue.wheel.RandomEx;

/**
 * 积分日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public class PntPointsLogTests {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private final ObjectMapper _objectMapper = new ObjectMapper();

    // @Test
    public void testCrud() throws IOException, ReflectiveOperationException {
        PntPointsLogMo mo = null;
        for (int i = 0; i < 20; i++) {
            mo = (PntPointsLogMo) RandomEx.randomPojo(PntPointsLogMo.class);
            mo.setId(null);
            System.out.println("添加积分日志的参数为：" + mo);
            final String addResult = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointslog", mo);
            System.out.println("添加积分日志的返回值为：" + addResult);
            final IdRo idRo = _objectMapper.readValue(addResult, IdRo.class);
            System.out.println(idRo);
            Assert.assertEquals(ResultDic.SUCCESS, idRo.getResult());
            mo.setId(Long.valueOf(idRo.getId()));
        }
        final String listResult = OkhttpUtils.get(hostUrl + "/pnt/pointslog?pageNum=1&pageSize=5");
        System.out.println("查询积分日志的返回值为：" + listResult);
        System.out.println("获取单个积分日志的参数为：" + mo.getId());
        final String getByIdResult = OkhttpUtils.get(hostUrl + "/pnt/pointslog/getbyid?id=" + mo.getId());
        System.out.println("获取单个积分日志的返回值为：" + getByIdResult);
        System.out.println("修改积分日志的参数为：" + mo);
        final String modifyResult = OkhttpUtils.putByJsonParams(hostUrl + "/pnt/pointslog", mo);
        System.out.println("修改积分日志类型的返回值为：" + modifyResult);
        final Ro modifyRo = _objectMapper.readValue(modifyResult, Ro.class);
        System.out.println(modifyRo);
        Assert.assertEquals(ResultDic.SUCCESS, modifyRo.getResult());
        System.out.println("删除积分日志的参数为：" + mo.getId());
        final String deleteResult = OkhttpUtils.delete(hostUrl + "/pnt/pointslog?id=" + mo.getId());
        System.out.println("删除积分日志的返回值为：" + deleteResult);
        final Ro deleteRo = _objectMapper.readValue(deleteResult, Ro.class);
        System.out.println(deleteRo);
        Assert.assertEquals(ResultDic.SUCCESS, deleteRo.getResult());
    }

    private final String hostUrl = "http://127.0.0.1:9010";

    @Test
    public void addPointTest() throws IOException {
        AddPointTradeTo to = new AddPointTradeTo();
        to.setAccountId(520391209198288896L);
        to.setPointsLogType((byte) PointLogTypeDic.ORDER_SETTLE.getCode());
        to.setChangedTitile("大卖网络-购买商品添加积分");
        to.setChangedDetail("测试商品");
        to.setOrderId(123456456710L);
        to.setOrderDetailId(7894561237L);
        to.setModifiedTimestamp(System.currentTimeMillis());
        to.setChangedPoints(BigDecimal.valueOf(6));
        String results = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointstrade", to);
        System.out.println(results);
        to = new AddPointTradeTo();
        to.setAccountId(520391209198288896L);
        to.setPointsLogType((byte) PointLogTypeDic.ORDER_RETURN.getCode());
        to.setChangedTitile("大卖网络-商品退货扣减积分");
        to.setChangedDetail("测试商品");
        to.setOrderId(123456456710L);
        to.setOrderDetailId(7894561237L);
        to.setModifiedTimestamp(System.currentTimeMillis());
        to.setChangedPoints(BigDecimal.valueOf(2));
        String resultss = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointstrade", to);
        System.out.println(resultss);
        to = new AddPointTradeTo();
        to.setAccountId(520391209198288896L);
        to.setPointsLogType((byte) PointLogTypeDic.VPAY_WITHDRAW.getCode());
        to.setChangedTitile("大卖网络-v支付提现扣减积分");
        to.setOrderId(123456456711L);
        to.setModifiedTimestamp(System.currentTimeMillis());
        to.setChangedPoints(BigDecimal.valueOf(2));
        String resultsss = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/pointstrade", to);
        System.out.println(resultsss);
    }
}
