package com.nas.msc.pdtm.pdt_element.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.pdt_element.service.IPdtElementService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.PdtElement;
import com.nas.msc.pdtm.pdt_element.dao.IPdtElementDao;

@Service
public class PdtElementService extends NASService<PdtElement> implements
		IPdtElementService {
	@Autowired
	@Override
	public void setDao(@Qualifier("pdtElementDao") IBaseDao<PdtElement> dao) {
		super.setDao(dao);
	}

	@Override
	public IPdtElementDao getDao() {
		return (IPdtElementDao) super.getDao();
	}
}