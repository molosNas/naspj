package com.nas.msc.pdtm.pdt_model.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.pdt_model.dao.IPdtModelDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.PdtModel;

@Repository
public class PdtModelDao extends NASDao<PdtModel> implements IPdtModelDao {

}