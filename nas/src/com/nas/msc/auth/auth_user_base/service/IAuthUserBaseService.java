package com.nas.msc.auth.auth_user_base.service;

import java.util.List;

import com.molos.cds.service.IBaseService;
import com.nas.beans.AuthUserBase;

public interface IAuthUserBaseService extends IBaseService<AuthUserBase> {

	List<AuthUserBase> querySomeT();

}