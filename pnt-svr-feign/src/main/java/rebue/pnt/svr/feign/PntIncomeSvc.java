package rebue.pnt.svr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import rebue.pnt.mo.PntAccountMo;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "pnt-svr", configuration = FeignConfig.class)
public interface PntIncomeSvc {

	/**
	 * 执行积分收益任务 
	 */
    @PostMapping("/pnt/income/executetask")
	void executePointIncomeTask(@RequestBody PntAccountMo mo);
}
