package com.nas.msc.basemvc.service;

import java.util.Map;

import com.molos.cds.service.IBaseService;

/**
 * NAS 服务接口
 * 
 * @author YangH
 * 
 * @param <T>
 */
public interface INASService<T> extends IBaseService<T> {

	/**
	 * 查询数据列表并返回为easyUI所需要的JSON MAP格式
	 * 
	 * @param current
	 *            当前页号
	 * @param size
	 *            每页数据大小
	 * @return
	 */
	Map<String, Object> query4EUI(int current, int size);
}
