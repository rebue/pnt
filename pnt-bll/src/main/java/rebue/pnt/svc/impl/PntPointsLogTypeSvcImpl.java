package rebue.pnt.svc.impl;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.pnt.dao.PntPointsLogTypeDao;
import rebue.pnt.jo.PntPointsLogTypeJo;
import rebue.pnt.mapper.PntPointsLogTypeMapper;
import rebue.pnt.mo.PntPointsLogTypeMo;
import rebue.pnt.svc.PntPointsLogTypeSvc;
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
public class PntPointsLogTypeSvcImpl extends BaseSvcImpl<java.lang.String, PntPointsLogTypeJo, PntPointsLogTypeDao, PntPointsLogTypeMo, PntPointsLogTypeMapper> implements PntPointsLogTypeSvc {

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    private static final Logger _log = LoggerFactory.getLogger(PntPointsLogTypeSvcImpl.class);

    /**
     * @mbg.generated 自动生成，如需修改，请删除本行
     */
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int add(PntPointsLogTypeMo mo) {
        _log.info("添加积分日志类型");
        // 如果id为空那么自动生成分布式id
        if (mo.getId() == null || mo.getId().trim().isEmpty()) {
            mo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        }
        return super.add(mo);
    }
}
