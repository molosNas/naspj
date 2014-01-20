package com.nas.msc.pdtm.typedivers_attributetype.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nas.beans.TypediversAttributetype;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.msc.pdtm.typedivers_attributetype.dao.ITypediversAttributetypeDao;

@Repository
@SuppressWarnings("unchecked")
public class TypediversAttributetypeDao extends NASDao<TypediversAttributetype>
		implements ITypediversAttributetypeDao {
	@Override
	public List<TypediversAttributetype> queryAllName4Map() {
		String hql = "select new TypediversAttributetype(id,name) from TypediversAttributetype";
		return current().createQuery(hql).list();
	}

}