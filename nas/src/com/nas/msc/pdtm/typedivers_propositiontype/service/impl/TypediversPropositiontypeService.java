package com.nas.msc.pdtm.typedivers_propositiontype.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.TypediversPropositiontype;
import com.nas.msc.basemvc.service.impl.NASService;
import com.nas.msc.pdtm.typedivers_propositiontype.dao.ITypediversPropositiontypeDao;
import com.nas.msc.pdtm.typedivers_propositiontype.service.ITypediversPropositiontypeService;

@Service
public class TypediversPropositiontypeService extends
		NASService<TypediversPropositiontype> implements
		ITypediversPropositiontypeService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("typediversPropositiontypeDao") IBaseDao<TypediversPropositiontype> dao) {
		super.setDao(dao);
	}

	@Override
	public ITypediversPropositiontypeDao getDao() {
		return (ITypediversPropositiontypeDao) super.getDao();
	}

	@Override
	public List<Map<String, Object>> queryAll4Map() {
		List<TypediversPropositiontype> list = getDao().queryAllName4Map();
		List<Map<String, Object>> reList = new ArrayList<Map<String, Object>>();
		for (TypediversPropositiontype t : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", t.getId());
			map.put("val", t.getName());
			reList.add(map);
		}
		return reList;
	}
}