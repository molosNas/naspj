package com.nas.msc.pdtm.typedivers_attributetype.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nas.beans.PdtAttribute;
import com.nas.beans.TypediversAttributetype;
import com.nas.msc.basemvc.dao.impl.NASDao;
import com.nas.msc.pdtm.typedivers_attributetype.dao.ITypediversAttributetypeDao;

@Repository
@SuppressWarnings("unchecked")
public class TypediversAttributetypeDao extends NASDao<TypediversAttributetype>
		implements ITypediversAttributetypeDao {
	@Override
	public List<TypediversAttributetype> queryAllName4Map() {
		String hql = "select new TypediversAttributetype(id,name) from TypediversAttributetype";
		return current().createQuery(hql).list();
	}

	@Override
	public int referenceCount(int id) {
		Criteria c = current().createCriteria(PdtAttribute.class);
		c.createAlias("attributetype", "attr");
		c.add(Restrictions.eq("attr.id", id));
		c.setProjection(Projections.rowCount());
		Object o = c.uniqueResult();
		return Integer.valueOf(o.toString());
	}
}