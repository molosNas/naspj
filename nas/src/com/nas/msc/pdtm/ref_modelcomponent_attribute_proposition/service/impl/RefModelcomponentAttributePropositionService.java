package com.nas.msc.pdtm.ref_modelcomponent_attribute_proposition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.ref_modelcomponent_attribute_proposition.service.IRefModelcomponentAttributePropositionService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.RefModelcomponentAttributeProposition;
import com.nas.msc.pdtm.ref_modelcomponent_attribute_proposition.dao.IRefModelcomponentAttributePropositionDao;

@Service
public class RefModelcomponentAttributePropositionService extends
		NASService<RefModelcomponentAttributeProposition> implements
		IRefModelcomponentAttributePropositionService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("refModelcomponentAttributePropositionDao") IBaseDao<RefModelcomponentAttributeProposition> dao) {
		super.setDao(dao);
	}

	@Override
	public IRefModelcomponentAttributePropositionDao getDao() {
		return (IRefModelcomponentAttributePropositionDao) super.getDao();
	}
}