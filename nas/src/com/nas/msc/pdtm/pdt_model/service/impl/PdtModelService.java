package com.nas.msc.pdtm.pdt_model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.pdt_model.service.IPdtModelService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.PdtModel;
import com.nas.msc.pdtm.pdt_model.dao.IPdtModelDao;

@Service
public class PdtModelService extends NASService<PdtModel> implements
		IPdtModelService {
	@Autowired
	@Override
	public void setDao(@Qualifier("pdtModelDao") IBaseDao<PdtModel> dao) {
		super.setDao(dao);
	}

	@Override
	public IPdtModelDao getDao() {
		return (IPdtModelDao) super.getDao();
	}
}