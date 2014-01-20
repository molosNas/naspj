package com.nas.msc.pdtm.typedivers_propositiontype.service;

import java.util.List;
import java.util.Map;

import com.nas.msc.basemvc.service.INASService;
import com.nas.beans.TypediversPropositiontype;

public interface ITypediversPropositiontypeService extends
		INASService<TypediversPropositiontype> {

	List<Map<String, Object>> queryAll4Map();

}