package rebue.pnt.svc.impl;

import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.pnt.dao.PntLogTypeDao;
import rebue.pnt.jo.PntLogTypeJo;
import rebue.pnt.mapper.PntLogTypeMapper;
import rebue.pnt.mo.PntLogTypeMo;
import rebue.pnt.svc.PntLogTypeSvc;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.BaseSvcImpl;

/**
 * 积分日志类型
 *
 * 在单独使用不带任何参数的 @Transactional 注释时，
 * propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED，
 * 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意：
 * 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class PntLogTypeSvcImpl extends BaseSvcImpl<java.lang.String, PntLogTypeJo, PntLogTypeDao, PntLogTypeMo, PntLogTypeMapper> implements PntLogTypeSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntLogTypeSvcImpl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(PntLogTypeMo mo) {
        _log.info("添加积分日志类型");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId().trim().isEmpty()) {
            mo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        return super.add(mo);
    }

    @Override
    public Ro testJpa() {
        _log.info("测试JPA");
        final Ro ro = new Ro();
        final List<PntLogTypeJo> list = _dao.findAll();
        _log.debug("返回列表: {}", list);
        ro.setResult(ResultDic.SUCCESS);
        ro.setMsg("测试JPA成功");
        return ro;
    }
}
