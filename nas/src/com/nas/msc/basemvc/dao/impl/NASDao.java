package com.nas.msc.basemvc.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.molos.cds.dao.imp.BaseDao;
import com.nas.msc.basemvc.dao.INASDao;

/**
 * NAS DAO默认实现对象
 * 
 * @author YangH
 * 
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class NASDao<T> extends BaseDao<T> implements INASDao<T> {

	@Override
	public Map<String, Object> query4EUI(int current, int size) {
		Map<String, Object> map = new HashMap<String, Object>();
		Criteria c = current().createCriteria(clazz);
		map.put("total", c.setProjection(Projections.rowCount()).uniqueResult());
		c.setProjection(null);
		map.put("rows",
				c.setFirstResult((current - 1) * size).setMaxResults(size)
						.list());
		return map;
	}

	@Override
	public List<T> queryByParaAndVal(String paraName, String val) {
		return current().createCriteria(clazz)
				.add(Restrictions.eq(paraName, val)).list();
	}
}
