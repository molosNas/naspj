package com.nas.msc.basemvc.service.impl;

import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.molos.cds.service.imp.BaseService;
import com.nas.msc.basemvc.dao.INASDao;
import com.nas.msc.basemvc.service.INASService;

/**
 * NAS 服务默认实现对象
 * 
 * @author YangH
 * 
 * @param <T>
 */
@Transactional
public abstract class NASService<T> extends BaseService<T> implements
		INASService<T> {

	@Override
	public INASDao<T> getDao() {
		return (INASDao<T>) super.getDao();
	}

	@Override
	public Map<String, Object> query4EUI(int current, int size) {
		return getDao().query4EUI(current, size);
	}
}
