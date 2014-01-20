package com.nas.msc.pdtm.typedivers_annextype.service;

import com.nas.msc.basemvc.service.INASService;
import com.nas.beans.TypediversAnnextype;

public interface ITypediversAnnextypeService extends
		INASService<TypediversAnnextype> {

	boolean isReference(int id);

}