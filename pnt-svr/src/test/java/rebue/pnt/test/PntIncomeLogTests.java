package rebue.pnt.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import rebue.pnt.dic.IncomeLogTypeDic;
import rebue.pnt.mo.PntIncomeLogMo;
import rebue.pnt.to.AddIncomeTradeTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;
import rebue.wheel.OkhttpUtils;
import rebue.wheel.RandomEx;

/**
 * 收益日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public class PntIncomeLogTests {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private final ObjectMapper _objectMapper = new ObjectMapper();

    // @Test
    public void testCrud() throws IOException, ReflectiveOperationException {
        PntIncomeLogMo mo = null;
        for (int i = 0; i < 20; i++) {
            mo = (PntIncomeLogMo) RandomEx.randomPojo(PntIncomeLogMo.class);
            mo.setId(null);
            System.out.println("添加收益日志的参数为：" + mo);
            final String addResult = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/incomelog", mo);
            System.out.println("添加收益日志的返回值为：" + addResult);
            final IdRo idRo = _objectMapper.readValue(addResult, IdRo.class);
            System.out.println(idRo);
            Assert.assertEquals(ResultDic.SUCCESS, idRo.getResult());
            mo.setId(Long.valueOf(idRo.getId()));
        }
        final String listResult = OkhttpUtils.get(hostUrl + "/pnt/incomelog?pageNum=1&pageSize=5");
        System.out.println("查询收益日志的返回值为：" + listResult);
        System.out.println("获取单个收益日志的参数为：" + mo.getId());
        final String getByIdResult = OkhttpUtils.get(hostUrl + "/pnt/incomelog/getbyid?id=" + mo.getId());
        System.out.println("获取单个收益日志的返回值为：" + getByIdResult);
        System.out.println("修改收益日志的参数为：" + mo);
        final String modifyResult = OkhttpUtils.putByJsonParams(hostUrl + "/pnt/incomelog", mo);
        System.out.println("修改积分日志类型的返回值为：" + modifyResult);
        final Ro modifyRo = _objectMapper.readValue(modifyResult, Ro.class);
        System.out.println(modifyRo);
        Assert.assertEquals(ResultDic.SUCCESS, modifyRo.getResult());
        System.out.println("删除收益日志的参数为：" + mo.getId());
        final String deleteResult = OkhttpUtils.delete(hostUrl + "/pnt/incomelog?id=" + mo.getId());
        System.out.println("删除收益日志的返回值为：" + deleteResult);
        final Ro deleteRo = _objectMapper.readValue(deleteResult, Ro.class);
        System.out.println(deleteRo);
        Assert.assertEquals(ResultDic.SUCCESS, deleteRo.getResult());
    }

    private final String hostUrl = "http://127.0.0.1:9010";

    @Test
    public void addIncomeTradeTest() throws IOException {
        AddIncomeTradeTo to = new AddIncomeTradeTo();
        to.setAccountId(525616558689484801L);
        to.setIncomeLogType((byte) IncomeLogTypeDic.DAY_INCOME.getCode());
        to.setChangedIncome(BigDecimal.valueOf(8));
        to.setChangedTitile("大卖网络-积分日收益");
        to.setChangedDetail("测试积分日收益");
        to.setModifiedTimestamp(System.currentTimeMillis());
        to.setStatDate(new Date());
        String string = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/incometrade", to);
        System.out.println(string);
        to = new AddIncomeTradeTo();
        to.setAccountId(525616558689484801L);
        to.setIncomeLogType((byte) IncomeLogTypeDic.TRANSFER_OUT_INCOME.getCode());
        to.setChangedIncome(BigDecimal.valueOf(2));
        to.setChangedTitile("大卖网络-收益转出");
        to.setChangedDetail("测试收益转出");
        to.setModifiedTimestamp(System.currentTimeMillis());
        to.setStatDate(new Date());
        String strings = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/incometrade", to);
        System.out.println(strings);
    }
}
