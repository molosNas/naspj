package com.nas.msc.auth.auth_user_group.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.molos.cds.service.imp.BaseService;
import com.nas.beans.AuthUserGroup;
import com.nas.msc.auth.auth_user_group.service.IAuthUserGroupService;

@Service
public class AuthUserGroupService extends BaseService<AuthUserGroup> implements
		IAuthUserGroupService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("authUserGroupDao") IBaseDao<AuthUserGroup> dao) {
		super.setDao(dao);
	}
}