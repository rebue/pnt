package rebue.pnt.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import rebue.pnt.mo.PntPointLogMo;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "pnt-svr", configuration = FeignConfig.class)
public interface PntPointLogSvc {

	/**
     * 根据账号id查询最新的一条积分日志信息
     * @param accountId
     * @return
     */
	PntPointLogMo getNewOne(@RequestParam("accountId") Long accountId);
}
