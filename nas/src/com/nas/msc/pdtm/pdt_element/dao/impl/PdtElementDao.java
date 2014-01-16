package com.nas.msc.pdtm.pdt_element.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.pdt_element.dao.IPdtElementDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.PdtElement;

@Repository
public class PdtElementDao extends NASDao<PdtElement> implements IPdtElementDao {

}