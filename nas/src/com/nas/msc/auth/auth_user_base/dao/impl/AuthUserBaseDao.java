package com.nas.msc.auth.auth_user_base.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.molos.cds.dao.imp.BaseDao;
import com.molos.tools.common.Checker;
import com.nas.beans.AuthUserBase;
import com.nas.msc.auth.auth_user_base.dao.IAuthUserBaseDao;

@Repository
@SuppressWarnings("unchecked")
public class AuthUserBaseDao extends BaseDao<AuthUserBase> implements
		IAuthUserBaseDao {

	@Override
	public AuthUserBase queryUserBase(AuthUserBase ab) {
		List<AuthUserBase> abList = current()
				.createCriteria(AuthUserBase.class)
				.add(Restrictions.eq("uname", ab.getUname()))
				.add(Restrictions.eq("pazzwd", ab.getPazzwd())).list();
		return Checker.notNullList(abList) ? abList.get(0) : null;
	}
}