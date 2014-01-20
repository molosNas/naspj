package com.nas.msc.pdtm.typedivers_attributetype.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.molos.cds.dao.IBaseDao;
import com.nas.beans.TypediversAttributetype;
import com.nas.msc.basemvc.service.impl.NASService;
import com.nas.msc.pdtm.typedivers_attributetype.dao.ITypediversAttributetypeDao;
import com.nas.msc.pdtm.typedivers_attributetype.service.ITypediversAttributetypeService;

@Service
public class TypediversAttributetypeService extends
		NASService<TypediversAttributetype> implements
		ITypediversAttributetypeService {
	@Autowired
	@Override
	public void setDao(
			@Qualifier("typediversAttributetypeDao") IBaseDao<TypediversAttributetype> dao) {
		super.setDao(dao);
	}

	@Override
	public ITypediversAttributetypeDao getDao() {
		return (ITypediversAttributetypeDao) super.getDao();
	}

	@Override
	public List<Map<String, Object>> queryAll4Map() {
		List<TypediversAttributetype> list = getDao().queryAllName4Map();
		List<Map<String, Object>> reList = new ArrayList<Map<String, Object>>();
		for (TypediversAttributetype t : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", t.getId());
			map.put("val", t.getName());
			reList.add(map);
		}
		return reList;
	}

	@Override
	public boolean isReference(int id) {
		// List<PdtAttribute> list=getDao().
		int count = getDao().referenceCount(id);
		return count != 0 ? true : false;
	}

}