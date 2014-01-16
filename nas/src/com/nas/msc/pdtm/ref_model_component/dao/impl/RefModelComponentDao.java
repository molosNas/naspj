package com.nas.msc.pdtm.ref_model_component.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.ref_model_component.dao.IRefModelComponentDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.RefModelComponent;

@Repository
public class RefModelComponentDao extends NASDao<RefModelComponent> implements
		IRefModelComponentDao {

}