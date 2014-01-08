package com.nas.msc.auth.auth_user_base.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.molos.cds.dao.imp.BaseDao;
import com.nas.beans.AuthUserBase;
import com.nas.msc.auth.auth_user_base.dao.IAuthUserBaseDao;

@Repository
public class AuthUserBaseDao extends BaseDao<AuthUserBase> implements
		IAuthUserBaseDao {

	@Override
	public List<AuthUserBase> q() {
		// current().createCriteria(AuthUserBase.class)
		// .add(Restrictions.eq("id", 1)).list();
		return queryList();
	}

}