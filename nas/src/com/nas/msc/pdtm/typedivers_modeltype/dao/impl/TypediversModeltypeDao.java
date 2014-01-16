package com.nas.msc.pdtm.typedivers_modeltype.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nas.beans.TypediversModeltype;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.msc.pdtm.typedivers_modeltype.dao.ITypediversModeltypeDao;

@Repository
@SuppressWarnings("unchecked")
public class TypediversModeltypeDao extends NASDao<TypediversModeltype>
		implements ITypediversModeltypeDao {

	@Override
	public List<TypediversModeltype> queryByName(String name) {
		return current().createCriteria(TypediversModeltype.class)
				.add(Restrictions.eq("name", name)).list();
	}

}