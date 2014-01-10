package com.nas.msc.auth.auth_resource.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.beans.AuthResource;
import com.nas.msc.auth.auth_resource.dao.IAuthResourceDao;
import com.nas.msc.basemvc.dao.impl.NASDao;

@Repository
public class AuthResourceDao extends NASDao<AuthResource> implements
		IAuthResourceDao {

}