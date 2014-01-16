package com.nas.msc.pdtm.pdt_proposition.dao.impl;

import org.springframework.stereotype.Repository;

import com.nas.msc.pdtm.pdt_proposition.dao.IPdtPropositionDao;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.beans.PdtProposition;

@Repository
public class PdtPropositionDao extends NASDao<PdtProposition> implements
		IPdtPropositionDao {

}