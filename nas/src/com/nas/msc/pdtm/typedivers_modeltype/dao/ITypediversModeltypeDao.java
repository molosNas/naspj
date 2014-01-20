package com.nas.msc.pdtm.typedivers_modeltype.dao;

import java.util.List;

import com.nas.beans.TypediversModeltype;
import com.nas.msc.basemvc.dao.INASDao;

public interface ITypediversModeltypeDao extends INASDao<TypediversModeltype> {

	List<TypediversModeltype> queryByName(String name);

	int referenceCount(int id);

	List<TypediversModeltype> queryAllName4Map();

}