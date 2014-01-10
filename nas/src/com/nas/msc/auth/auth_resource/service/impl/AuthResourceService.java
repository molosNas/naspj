package com.nas.msc.auth.auth_resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.AuthResource;
import com.nas.msc.auth.auth_resource.service.IAuthResourceService;
import com.nas.msc.basemvc.service.impl.NASService;

@Service
public class AuthResourceService extends NASService<AuthResource> implements
		IAuthResourceService {
	@Autowired
	@Override
	public void setDao(@Qualifier("authResourceDao") IBaseDao<AuthResource> dao) {
		super.setDao(dao);
	}
}