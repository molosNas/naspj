package com.nas.msc.pdtm.typedivers_propositiontype.dao;

import java.util.List;

import com.nas.msc.basemvc.dao.INASDao;
import com.nas.beans.TypediversPropositiontype;

public interface ITypediversPropositiontypeDao extends
		INASDao<TypediversPropositiontype> {

	List<TypediversPropositiontype> queryAllName4Map();

}