package com.nas.msc.auth.auth_user_base.service;

import com.molos.cds.service.IBaseService;
import com.nas.beans.AuthUserBase;

public interface IAuthUserBaseService extends IBaseService<AuthUserBase> {

	AuthUserBase queryUserBase(AuthUserBase ab);

	Object assemResources(AuthUserBase ab);

}