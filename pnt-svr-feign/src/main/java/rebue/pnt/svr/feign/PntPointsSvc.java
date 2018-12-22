package rebue.pnt.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rebue.pnt.to.AddPointTradeTo;
import rebue.robotech.ro.Ro;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "pnt-svr", configuration = FeignConfig.class)
public interface PntPointsSvc {

	/**
     * 添加积分交易
     * @param to
     * @return
     */
    @PostMapping("/pnt/pointstrade")
    Ro addPointTrade(@RequestBody AddPointTradeTo to);
}
