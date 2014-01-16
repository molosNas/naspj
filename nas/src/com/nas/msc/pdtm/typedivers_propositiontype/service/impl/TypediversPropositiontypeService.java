package com.nas.msc.pdtm.typedivers_propositiontype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.typedivers_propositiontype.service.ITypediversPropositiontypeService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.TypediversPropositiontype;
import com.nas.msc.pdtm.typedivers_propositiontype.dao.ITypediversPropositiontypeDao;

@Service
public class TypediversPropositiontypeService extends
		NASService<TypediversPropositiontype> implements
		ITypediversPropositiontypeService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("typediversPropositiontypeDao") IBaseDao<TypediversPropositiontype> dao) {
		super.setDao(dao);
	}

	@Override
	public ITypediversPropositiontypeDao getDao() {
		return (ITypediversPropositiontypeDao) super.getDao();
	}
}