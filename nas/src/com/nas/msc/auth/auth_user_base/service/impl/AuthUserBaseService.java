package com.nas.msc.auth.auth_user_base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.molos.cds.service.imp.BaseService;
import com.nas.beans.AuthUserBase;
import com.nas.msc.auth.auth_user_base.dao.IAuthUserBaseDao;
import com.nas.msc.auth.auth_user_base.service.IAuthUserBaseService;

@Service
public class AuthUserBaseService extends BaseService<AuthUserBase> implements
		IAuthUserBaseService {
	@Autowired
	@Override
	public void setDao(@Qualifier("authUserBaseDao") IBaseDao<AuthUserBase> dao) {
		super.setDao(dao);
	}

	@Override
	public IAuthUserBaseDao getDao() {
		return (IAuthUserBaseDao) super.getDao();
	}

	@Override
	public AuthUserBase queryUserBase(AuthUserBase ab) {
		return getDao().queryUserBase(ab);
	}

	@Override
	public Object assemResources(AuthUserBase ab) {
		
		return null;
	}
}