package com.nas.msc.pdtm.pdt_component.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.pdt_component.service.IPdtComponentService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.PdtComponent;
import com.nas.msc.pdtm.pdt_component.dao.IPdtComponentDao;

@Service
public class PdtComponentService extends NASService<PdtComponent> implements
		IPdtComponentService {
	@Autowired
	@Override
	public void setDao(@Qualifier("pdtComponentDao") IBaseDao<PdtComponent> dao) {
		super.setDao(dao);
	}

	@Override
	public IPdtComponentDao getDao() {
		return (IPdtComponentDao) super.getDao();
	}
}