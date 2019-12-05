package rebue.pnt.test;

import java.io.IOException;
import java.util.Date;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import rebue.pnt.mo.PntAccountMo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;
import rebue.wheel.OkhttpUtils;
import rebue.wheel.RandomEx;
import rebue.wheel.idworker.IdWorker3;

/**
 * 积分账户信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
public class PntAccountTests {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private final ObjectMapper _objectMapper = new ObjectMapper();

    // @Test
    public void testCrud() throws IOException, ReflectiveOperationException {
        PntAccountMo mo = null;
        for (int i = 0; i < 20; i++) {
            mo = (PntAccountMo) RandomEx.randomPojo(PntAccountMo.class);
            mo.setId(null);
            System.out.println("添加积分账户信息的参数为：" + mo);
            final String addResult = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/account", mo);
            System.out.println("添加积分账户信息的返回值为：" + addResult);
            final IdRo idRo = _objectMapper.readValue(addResult, IdRo.class);
            System.out.println(idRo);
            Assert.assertEquals(ResultDic.SUCCESS, idRo.getResult());
            mo.setId(Long.valueOf(idRo.getId()));
        }
        final String listResult = OkhttpUtils.get(hostUrl + "/pnt/account?pageNum=1&pageSize=5");
        System.out.println("查询积分账户信息的返回值为：" + listResult);
        System.out.println("获取单个积分账户信息的参数为：" + mo.getId());
        final String getByIdResult = OkhttpUtils.get(hostUrl + "/pnt/account/getbyid?id=" + mo.getId());
        System.out.println("获取单个积分账户信息的返回值为：" + getByIdResult);
        System.out.println("修改积分账户信息的参数为：" + mo);
        final String modifyResult = OkhttpUtils.putByJsonParams(hostUrl + "/pnt/account", mo);
        System.out.println("修改积分日志类型的返回值为：" + modifyResult);
        final Ro modifyRo = _objectMapper.readValue(modifyResult, Ro.class);
        System.out.println(modifyRo);
        Assert.assertEquals(ResultDic.SUCCESS, modifyRo.getResult());
        System.out.println("删除积分账户信息的参数为：" + mo.getId());
        final String deleteResult = OkhttpUtils.delete(hostUrl + "/pnt/account?id=" + mo.getId());
        System.out.println("删除积分账户信息的返回值为：" + deleteResult);
        final Ro deleteRo = _objectMapper.readValue(deleteResult, Ro.class);
        System.out.println(deleteRo);
        Assert.assertEquals(ResultDic.SUCCESS, deleteRo.getResult());
    }

    private final String hostUrl = "http://127.0.0.1:9010";

//    @Test
    public void addTest() throws IOException {
        IdWorker3    idWorker3 = new IdWorker3();
        PntAccountMo mo        = new PntAccountMo();
        mo.setId(idWorker3.getId());
        final Date now = new Date();
        mo.setModifiedTimestamp(now.getTime());
        final String addResult = OkhttpUtils.postByJsonParams(hostUrl + "/pnt/account", mo);
        System.out.println("添加积分账户信息的返回值为：" + addResult);
    }

    @Test
    public void addPoint() throws IOException {
        final String addResult = OkhttpUtils.post(hostUrl + "/pnt/account/compensate-point");
        System.out.println("积分补偿的返回值为：" + addResult);

    }
}
