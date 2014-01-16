package com.nas.msc.pdtm.pdt_proposition.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.pdt_proposition.service.IPdtPropositionService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.PdtProposition;
import com.nas.msc.pdtm.pdt_proposition.dao.IPdtPropositionDao;

@Service
public class PdtPropositionService extends NASService<PdtProposition> implements
		IPdtPropositionService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("pdtPropositionDao") IBaseDao<PdtProposition> dao) {
		super.setDao(dao);
	}

	@Override
	public IPdtPropositionDao getDao() {
		return (IPdtPropositionDao) super.getDao();
	}
}