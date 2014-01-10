package com.nas.msc.auth.auth_rel_group_role.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.beans.AuthRelGroupRole;
import com.nas.msc.auth.auth_rel_group_role.dao.IAuthRelGroupRoleDao;
import com.nas.msc.basemvc.dao.impl.NASDao;

@Repository
public class AuthRelGroupRoleDao extends NASDao<AuthRelGroupRole> implements
		IAuthRelGroupRoleDao {

}