package com.nas.msc.auth.auth_user_group.dao.impl;

import org.springframework.stereotype.Repository;

import com.molos.cds.dao.imp.BaseDao;
import com.nas.beans.AuthUserGroup;
import com.nas.msc.auth.auth_user_group.dao.IAuthUserGroupDao;

@Repository
public class AuthUserGroupDao extends BaseDao<AuthUserGroup> implements
		IAuthUserGroupDao {

}