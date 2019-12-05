package rebue.pnt.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.svc.PntAccountSvc;
import rebue.pnt.to.ModifyPointTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;

/**
 * 积分账户信息
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class PntAccountCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntAccountCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private PntAccountSvc svc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String _uniqueFilesName = "某字段内容";

    /**
     * 添加积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PostMapping("/pnt/account")
    IdRo add(@RequestBody PntAccountMo mo) throws Exception {
        _log.info("add PntAccountMo: {}", mo);
        IdRo ro = new IdRo();
        try {
            int result = svc.add(mo);
            if (result == 1) {
                String msg = "添加成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                ro.setId(mo.getId().toString());
                return ro;
            } else {
                String msg = "添加失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "添加失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "添加失败，出现运行时异常";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 修改积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/pnt/account")
    Ro modify(@RequestBody PntAccountMo mo) throws Exception {
        _log.info("modify PntAccountMo: {}", mo);
        Ro ro = new Ro();
        try {
            if (svc.modify(mo) == 1) {
                String msg = "修改成功";
                _log.info("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                String msg = "修改失败";
                _log.error("{}: mo-{}", msg, mo);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "修改失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error(msg + ": mo=" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "修改失败，出现运行时异常";
            _log.error(msg + ": mo-" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 删除积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/pnt/account")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del PntAccountMo by id: {}", id);
        int result = svc.del(id);
        Ro  ro     = new Ro();
        if (result == 1) {
            String msg = "删除成功";
            _log.info("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.SUCCESS);
            return ro;
        } else {
            String msg = "删除失败，找不到该记录";
            _log.error("{}: id-{}", msg, id);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 查询积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/pnt/account")
    PageInfo<PntAccountMo> list(PntAccountMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 5;
        _log.info("list PntAccountMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<PntAccountMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个积分账户信息
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/pnt/account/getbyid")
    PntAccountMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get PntAccountMo by id: {}", id);
        return svc.getById(id);
    }

    /**
     * 积分充值
     * 
     * @param mo
     * @return
     * @throws Exception
     */
    @PutMapping("/pnt/account/recharge")
    Ro recharge(@RequestBody ModifyPointTo to) throws Exception {
        _log.info("modify ModifyPointTo: {}", to);
        Ro ro = new Ro();
        try {
            if (svc.rechargePoint(to).getResult() == ResultDic.SUCCESS) {
                String msg = "充值成功";
                _log.info("{}: to-{}", msg, to);
                ro.setMsg(msg);
                ro.setResult(ResultDic.SUCCESS);
                return ro;
            } else {
                String msg = "充值失败";
                _log.error("{}: to-{}", msg, to);
                ro.setMsg(msg);
                ro.setResult(ResultDic.FAIL);
                return ro;
            }
        } catch (DuplicateKeyException e) {
            String msg = "充值失败，" + _uniqueFilesName + "已存在，不允许出现重复";
            _log.error(msg + ": to=" + to, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            String msg = "充值失败，出现运行时异常";
            _log.error(msg + ": to-" + to, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 获取所有积分账号信息
     *
     * @return
     */
    @GetMapping("/pnt/account/all")
    List<PntAccountMo> listAll() {
        return svc.listAll();
    }

    /**
     * 获取需要计算日收益的账户列表
     * 
     * @param fetchCount 获取结果限制数量
     * @return
     */
    @GetMapping("/pnt/account/listtocalcdayincome")
    List<PntAccountMo> listToCalcDayIncome(@RequestParam("fetchCount") int fetchCount) {
        _log.info("开始获取获取需要计算日收益的账户列表，获取的条数为：{}", fetchCount);
        return svc.listToCalcDayIncome(fetchCount);
    }

    /**
     * 根据限制数量查询积分账号信息
     * 
     * @param limitCount
     * @return
     */
    @GetMapping("/pnt/account/bylimitcount")
    List<PntAccountMo> pntAccountByLimitCountList(@RequestParam("pageNum") Integer pageNum,
            @RequestParam("limitCount") Integer limitCount) {
        _log.info("根据限制数量查询积分账号信息的请求参数为：limitCount-{}, pageNum-{}", limitCount, pageNum);
        return svc.pntAccountByLimitCountList(pageNum, limitCount);
    }

    /**
     * 积分补偿
     * 
     * @return
     */
    @PostMapping("/pnt/account/compensate-point")
    Ro compensatePoint() {
        _log.info("开始进行积分补偿");
        return svc.compensatePoint();
    }
}
