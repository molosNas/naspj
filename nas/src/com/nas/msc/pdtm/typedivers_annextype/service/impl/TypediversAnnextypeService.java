package com.nas.msc.pdtm.typedivers_annextype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.TypediversAnnextype;
import com.nas.msc.basemvc.service.impl.NASService;
import com.nas.msc.pdtm.typedivers_annextype.dao.ITypediversAnnextypeDao;
import com.nas.msc.pdtm.typedivers_annextype.service.ITypediversAnnextypeService;

@Service
public class TypediversAnnextypeService extends NASService<TypediversAnnextype>
		implements ITypediversAnnextypeService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("typediversAnnextypeDao") IBaseDao<TypediversAnnextype> dao) {
		super.setDao(dao);
	}

	@Override
	public ITypediversAnnextypeDao getDao() {
		return (ITypediversAnnextypeDao) super.getDao();
	}

	@Override
	public boolean isReference(int id) {
		// List<pdta\>
		return false;
	}
}