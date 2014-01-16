package com.nas.msc.pdtm.ref_proposition_element.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nas.msc.pdtm.ref_proposition_element.service.IRefPropositionElementService;
import com.nas.msc.basemvc.service.impl.NASService;
import com.molos.cds.dao.IBaseDao;
import com.nas.beans.RefPropositionElement;
import com.nas.msc.pdtm.ref_proposition_element.dao.IRefPropositionElementDao;

@Service
public class RefPropositionElementService extends
		NASService<RefPropositionElement> implements
		IRefPropositionElementService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("refPropositionElementDao") IBaseDao<RefPropositionElement> dao) {
		super.setDao(dao);
	}

	@Override
	public IRefPropositionElementDao getDao() {
		return (IRefPropositionElementDao) super.getDao();
	}
}