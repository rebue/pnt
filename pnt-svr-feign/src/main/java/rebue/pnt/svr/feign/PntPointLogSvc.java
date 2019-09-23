package rebue.pnt.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.pnt.mo.PntPointLogMo;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "pnt-svr", configuration = FeignConfig.class, contextId = "pnt-svr-point-log")
public interface PntPointLogSvc {

    /**
     * 根据账号id查询最新的一条积分日志信息
     * 
     * @param accountId
     * @return
     */
    @GetMapping("/pnt/pointlog/getnewone")
    PntPointLogMo getNewOne(@RequestParam("accountId") Long accountId);

    /**
     * 根据账号id、订单id和日志状态判断是否有该条记录
     * 
     * @param pntPointLogMo
     * @return
     */
    @GetMapping("/pnt/pointlog/countByIdAndOrderId")
    int countByIdAndOrderId(@RequestBody PntPointLogMo pntPointLogMo);
}
