package com.nas.msc.pdtm.pdt_attribute.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.PdtAttribute;
import com.nas.msc.basemvc.service.impl.NASService;
import com.nas.msc.pdtm.pdt_attribute.dao.IPdtAttributeDao;
import com.nas.msc.pdtm.pdt_attribute.service.IPdtAttributeService;

@Service
public class PdtAttributeService extends NASService<PdtAttribute> implements
		IPdtAttributeService {
	@Autowired
	@Override
	public void setDao(@Qualifier("pdtAttributeDao") IBaseDao<PdtAttribute> dao) {
		super.setDao(dao);
	}

	@Override
	public IPdtAttributeDao getDao() {
		return (IPdtAttributeDao) super.getDao();
	}
}