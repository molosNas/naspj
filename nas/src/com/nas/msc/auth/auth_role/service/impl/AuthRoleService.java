package com.nas.msc.auth.auth_role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.molos.cds.service.imp.BaseService;
import com.nas.beans.AuthRole;
import com.nas.msc.auth.auth_role.service.IAuthRoleService;

@Service
public class AuthRoleService extends BaseService<AuthRole> implements
		IAuthRoleService {
	@Autowired
	@Override
	public void setDao(@Qualifier("authRoleDao") IBaseDao<AuthRole> dao) {
		super.setDao(dao);
	}
}