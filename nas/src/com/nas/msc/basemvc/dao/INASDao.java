package com.nas.msc.basemvc.dao;

import java.util.Map;

import com.molos.cds.dao.IBaseDao;

/**
 * NAS DAO接口
 * 
 * @author YangH
 * 
 * @param <T>
 */
public interface INASDao<T> extends IBaseDao<T> {

	Map<String, Object> query4EUI(int current, int size);
}
