package com.nas.msc.pdtm.typedivers_attributetype.service;

import java.util.List;
import java.util.Map;

import com.nas.msc.basemvc.service.INASService;
import com.nas.beans.TypediversAttributetype;

public interface ITypediversAttributetypeService extends
		INASService<TypediversAttributetype> {

	List<Map<String, Object>> queryAll4Map();

}