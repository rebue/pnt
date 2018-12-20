package rebue.pnt.ctrl;

import com.github.pagehelper.PageInfo;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import rebue.pnt.mo.PntPointsLogMo;
import rebue.pnt.svc.PntPointsLogSvc;
import rebue.pnt.to.AddPointTradeTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.IdRo;
import rebue.robotech.ro.Ro;

/**
 * 积分日志
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@RestController
public class PntPointsLogCtrl {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntPointsLogCtrl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Resource
    private PntPointsLogSvc svc;

    /**
     * 有唯一约束的字段名称
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private String _uniqueFilesName = "某字段内容";

    /**
     * 添加积分日志
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PostMapping("/pnt/pointslog")
    IdRo add(@RequestBody PntPointsLogMo mo) throws Exception {
        _log.info("add PntPointsLogMo: {}", mo);
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
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        } catch (RuntimeException e) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String msg = "添加失败，出现运行时异常(" + sdf.format(new Date()) + ")";
            _log.error(msg + ": mo=" + mo, e);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 修改积分日志
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @PutMapping("/pnt/pointslog")
    Ro modify(@RequestBody PntPointsLogMo mo) throws Exception {
        _log.info("modify PntPointsLogMo: {}", mo);
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
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String msg = "修改失败，出现运行时异常(" + sdf.format(new Date()) + ")";
            _log.error("{}: mo-{}", msg, mo);
            ro.setMsg(msg);
            ro.setResult(ResultDic.FAIL);
            return ro;
        }
    }

    /**
     * 删除积分日志
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @DeleteMapping("/pnt/pointslog")
    Ro del(@RequestParam("id") java.lang.Long id) {
        _log.info("del PntPointsLogMo by id: {}", id);
        int result = svc.del(id);
        Ro ro = new Ro();
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
     * 查询积分日志
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/pnt/pointslog")
    PageInfo<PntPointsLogMo> list(PntPointsLogMo mo, @RequestParam(value = "pageNum", required = false) Integer pageNum, @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        if (pageNum == null)
            pageNum = 1;
        if (pageSize == null)
            pageSize = 5;
        _log.info("list PntPointsLogMo:" + mo + ", pageNum = " + pageNum + ", pageSize = " + pageSize);
        if (pageSize > 50) {
            String msg = "pageSize不能大于50";
            _log.error(msg);
            throw new IllegalArgumentException(msg);
        }
        PageInfo<PntPointsLogMo> result = svc.list(mo, pageNum, pageSize);
        _log.info("result: " + result);
        return result;
    }

    /**
     * 获取单个积分日志
     *
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @GetMapping("/pnt/pointslog/getbyid")
    PntPointsLogMo getById(@RequestParam("id") java.lang.Long id) {
        _log.info("get PntPointsLogMo by id: {}", id);
        return svc.getById(id);
    }
    
    /**
     * 添加积分交易
     * @param to
     * @return
     */
    @PostMapping("/pnt/pointstrade")
    Ro addPointTrade(@RequestBody AddPointTradeTo to) {
    	_log.info("添加积分交易的参数为：{}", to);
    	try {
			return svc.addPointTrade(to);
		} catch (Exception e) {
			_log.info("添加积分交易出现错误，请求的参数为：{}, 错误信息为：{}", to, e);
			Ro ro = new Ro();
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("添加出错");
			return ro;
		}
    }
}
