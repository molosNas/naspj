package com.nas.msc.pdtm.typedivers_attributetype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.TypediversAttributetype;
import com.nas.msc.basemvc.service.impl.NASService;
import com.nas.msc.pdtm.typedivers_attributetype.dao.ITypediversAttributetypeDao;
import com.nas.msc.pdtm.typedivers_attributetype.service.ITypediversAttributetypeService;

@Service
public class TypediversAttributetypeService extends
		NASService<TypediversAttributetype> implements
		ITypediversAttributetypeService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("typediversAttributetypeDao") IBaseDao<TypediversAttributetype> dao) {
		super.setDao(dao);
	}

	@Override
	public ITypediversAttributetypeDao getDao() {
		return (ITypediversAttributetypeDao) super.getDao();
	}

}