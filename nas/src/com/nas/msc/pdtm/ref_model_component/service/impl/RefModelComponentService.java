package com.nas.msc.pdtm.ref_model_component.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.ref_model_component.service.IRefModelComponentService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.RefModelComponent;
import com.nas.msc.pdtm.ref_model_component.dao.IRefModelComponentDao;

@Service
public class RefModelComponentService extends NASService<RefModelComponent>
		implements IRefModelComponentService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("refModelComponentDao") IBaseDao<RefModelComponent> dao) {
		super.setDao(dao);
	}

	@Override
	public IRefModelComponentDao getDao() {
		return (IRefModelComponentDao) super.getDao();
	}
}