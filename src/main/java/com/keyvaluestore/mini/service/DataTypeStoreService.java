package com.keyvaluestore.mini.service;

import com.keyvaluestore.mini.model.Request;

/**
 * The interface Data type store service.
 */
public interface DataTypeStoreService {
	/**
	 * Save.
	 *
	 * @param request the request
	 */
void save(Request request);

	/**
	 * Remove.
	 *
	 * @param request the request
	 */
void remove(Request request);
}
