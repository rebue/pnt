package rebue.pnt.svr.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import rebue.pnt.mo.PntAccountMo;
import rebue.sbs.feign.FeignConfig;

@FeignClient(name = "pnt-svr", configuration = FeignConfig.class)
public interface PntAccountSvc {

	/**
     * 获取单个积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/pnt/account/getbyid")
    PntAccountMo getById(@RequestParam("id") java.lang.Long id);
    
    /**
	 * 获取需要计算日收益的账户列表
	 * @param fetchCount 获取结果限制数量
	 * @return
	 */
	@GetMapping("/pnt/account/listtocalcdayincome")
	List<PntAccountMo> listToCalcDayIncome(@RequestParam("fetchCount") int fetchCount);
	
	/**
     * 查询积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/pnt/account")
    PageInfo<PntAccountMo> list(@RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize);
}
