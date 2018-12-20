package rebue.pnt.svc.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import rebue.pnt.dao.PntAccountDao;
import rebue.pnt.jo.PntAccountJo;
import rebue.pnt.mapper.PntAccountMapper;
import rebue.pnt.mo.PntAccountMo;
import rebue.pnt.svc.PntAccountSvc;
import rebue.pnt.to.ModifyPointAccountTo;
import rebue.robotech.dic.ResultDic;
import rebue.robotech.ro.Ro;
import rebue.robotech.svc.impl.BaseSvcImpl;

/**
 * 积分账户信息
 *
 * 在单独使用不带任何参数的 @Transactional 注释时， propagation(传播模式)=REQUIRED，readOnly=false，
 * isolation(事务隔离级别)=READ_COMMITTED， 而且事务不会针对受控异常（checked exception）回滚。
 *
 * 注意： 一般是查询的数据库操作，默认设置readOnly=true, propagation=Propagation.SUPPORTS
 * 而涉及到增删改的数据库操作的方法，要设置 readOnly=false, propagation=Propagation.REQUIRED
 *
 * @mbg.generated 自动生成的注释，如需修改本注释，请删除本行
 */
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
@Service
public class PntAccountSvcImpl
		extends BaseSvcImpl<java.lang.Long, PntAccountJo, PntAccountDao, PntAccountMo, PntAccountMapper>
		implements PntAccountSvc {

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	private static final Logger _log = LoggerFactory.getLogger(PntAccountSvcImpl.class);

	/**
	 * @mbg.generated 自动生成，如需修改，请删除本行
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public int add(PntAccountMo mo) {
		_log.info("添加积分账户信息");
		// 如果id为空那么自动生成分布式id
		if (mo.getId() == null || mo.getId() == 0) {
			mo.setId(_idWorker.getId());
		}
		return super.add(mo);
	}

	/**
	 * 修改积分账号信息
	 * @param to
	 * @return
	 */
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Ro modifyPointAccount(ModifyPointAccountTo to) {
		_log.info("修改积分账号信息的请求参数为：{}", to);
		Ro ro = new Ro();
		if (to.getAccountId() == null || to.getNewPoints() == null || to.getOldPoints() == null
				|| to.getNewModifiedTimestamp() == null || to.getOldModifiedTimestamp() == null) {
			_log.error("修改积分账号信息时出现参数错误，请求的参数为：{}", to);
			ro.setResult(ResultDic.PARAM_ERROR);
			ro.setMsg("参数错误");
			return ro;
		}

		_log.info("修改积分账号信息的参数为：{}", to);
		int modifyAccountResult = _mapper.modifyAccount(to.getAccountId(), to.getNewPoints(), to.getOldPoints(),
				to.getNewModifiedTimestamp(), to.getOldModifiedTimestamp());
		_log.info("修改积分账号信息的返回值为：{}", modifyAccountResult);
		if (modifyAccountResult != 1) {
			_log.error("修改积分账号信息 出现错误，请求的参数为：{}", to);
			ro.setResult(ResultDic.FAIL);
			ro.setMsg("修改失败");
			return ro;
		}
		
		_log.info("修改积分账号信息成功，请求的参数为：{}", to);
		ro.setResult(ResultDic.SUCCESS);
		ro.setMsg("修改成功");
		return ro;
	}
}
