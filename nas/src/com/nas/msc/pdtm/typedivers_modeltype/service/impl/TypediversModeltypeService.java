package com.nas.msc.pdtm.typedivers_modeltype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.TypediversModeltype;
import com.nas.msc.basemvc.service.impl.NASService;
import com.nas.msc.pdtm.typedivers_modeltype.dao.ITypediversModeltypeDao;
import com.nas.msc.pdtm.typedivers_modeltype.service.ITypediversModeltypeService;

@Service
public class TypediversModeltypeService extends NASService<TypediversModeltype>
		implements ITypediversModeltypeService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("typediversModeltypeDao") IBaseDao<TypediversModeltype> dao) {
		super.setDao(dao);
	}

	@Override
	public ITypediversModeltypeDao getDao() {
		return (ITypediversModeltypeDao) super.getDao();
	}

	@Override
	public boolean isReference(int id) {
		int count = getDao().referenceCount(id);
		return count != 0 ? true : false;
	}

}