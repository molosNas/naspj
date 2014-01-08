package com.nas.msc.auth.auth_user_base.dao;

import java.util.List;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.AuthUserBase;

public interface IAuthUserBaseDao extends IBaseDao<AuthUserBase> {

	List<AuthUserBase> q();

}