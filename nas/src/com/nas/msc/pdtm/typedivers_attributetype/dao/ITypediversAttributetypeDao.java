package com.nas.msc.pdtm.typedivers_attributetype.dao;

import java.util.List;

import com.nas.beans.TypediversAttributetype;
import com.nas.msc.basemvc.dao.INASDao;

public interface ITypediversAttributetypeDao extends
		INASDao<TypediversAttributetype> {

	List<TypediversAttributetype> queryAllName4Map();

	int referenceCount(int id);

}