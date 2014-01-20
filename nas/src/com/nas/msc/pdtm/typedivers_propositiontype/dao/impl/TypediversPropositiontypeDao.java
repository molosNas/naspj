package com.nas.msc.pdtm.typedivers_propositiontype.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.typedivers_propositiontype.dao.ITypediversPropositiontypeDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.TypediversPropositiontype;

@Repository
public class TypediversPropositiontypeDao extends
		NASDao<TypediversPropositiontype> implements
		ITypediversPropositiontypeDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TypediversPropositiontype> queryAllName4Map() {
		String hql = "select new TypediversPropositiontype(id,name) from TypediversPropositiontype";
		return current().createQuery(hql).list();
	}

}