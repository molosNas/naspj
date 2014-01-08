package com.nas.msc.auth.auth_resource.dao.impl;

import org.springframework.stereotype.Repository;

import com.molos.cds.dao.imp.BaseDao;
import com.nas.beans.AuthResource;
import com.nas.msc.auth.auth_resource.dao.IAuthResourceDao;

@Repository
public class AuthResourceDao extends BaseDao<AuthResource> implements
		IAuthResourceDao {

}