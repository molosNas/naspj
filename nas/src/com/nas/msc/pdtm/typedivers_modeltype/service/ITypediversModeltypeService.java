package com.nas.msc.pdtm.typedivers_modeltype.service;

import java.util.List;
import java.util.Map;

import com.nas.beans.TypediversModeltype;
import com.nas.msc.basemvc.service.INASService;

public interface ITypediversModeltypeService extends
		INASService<TypediversModeltype> {

	boolean isReference(int id);

	List<Map<String, Object>> queryAll4Map();

}