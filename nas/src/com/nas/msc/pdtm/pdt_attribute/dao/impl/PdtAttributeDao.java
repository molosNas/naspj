package com.nas.msc.pdtm.pdt_attribute.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.pdt_attribute.dao.IPdtAttributeDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.PdtAttribute;

@Repository
public class PdtAttributeDao extends NASDao<PdtAttribute> implements
		IPdtAttributeDao {

}