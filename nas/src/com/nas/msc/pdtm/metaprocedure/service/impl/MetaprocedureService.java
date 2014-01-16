package com.nas.msc.pdtm.metaprocedure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.metaprocedure.service.IMetaprocedureService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.Metaprocedure;
import com.nas.msc.pdtm.metaprocedure.dao.IMetaprocedureDao;

@Service
public class MetaprocedureService extends NASService<Metaprocedure> implements
		IMetaprocedureService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("metaprocedureDao") IBaseDao<Metaprocedure> dao) {
		super.setDao(dao);
	}

	@Override
	public IMetaprocedureDao getDao() {
		return (IMetaprocedureDao) super.getDao();
	}
}