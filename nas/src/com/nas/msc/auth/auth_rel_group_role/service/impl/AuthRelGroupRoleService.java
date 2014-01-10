package com.nas.msc.auth.auth_rel_group_role.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.AuthRelGroupRole;
import com.nas.msc.auth.auth_rel_group_role.service.IAuthRelGroupRoleService;
import com.nas.msc.basemvc.service.impl.NASService;

@Service
public class AuthRelGroupRoleService extends NASService<AuthRelGroupRole>
		implements IAuthRelGroupRoleService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("authRelGroupRoleDao") IBaseDao<AuthRelGroupRole> dao) {
		super.setDao(dao);
	}
}