package com.nas.msc.pdtm.pdt_component.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.beans.PdtComponent;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.msc.pdtm.pdt_component.dao.IPdtComponentDao;

@Repository
public class PdtComponentDao extends NASDao<PdtComponent> implements
		IPdtComponentDao {

}