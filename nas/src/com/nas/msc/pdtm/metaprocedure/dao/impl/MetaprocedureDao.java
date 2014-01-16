package com.nas.msc.pdtm.metaprocedure.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.metaprocedure.dao.IMetaprocedureDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.Metaprocedure;

@Repository
public class MetaprocedureDao extends NASDao<Metaprocedure> implements
		IMetaprocedureDao {

}