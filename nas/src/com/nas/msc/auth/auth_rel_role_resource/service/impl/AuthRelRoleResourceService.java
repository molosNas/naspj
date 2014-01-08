package com.nas.msc.auth.auth_rel_role_resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.molos.cds.service.imp.BaseService;
import com.nas.beans.AuthRelRoleResource;
import com.nas.msc.auth.auth_rel_role_resource.service.IAuthRelRoleResourceService;

@Service
public class AuthRelRoleResourceService extends
		BaseService<AuthRelRoleResource> implements IAuthRelRoleResourceService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("authRelRoleResourceDao") IBaseDao<AuthRelRoleResource> dao) {
		super.setDao(dao);
	}
}