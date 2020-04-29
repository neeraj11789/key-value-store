package com.keyvaluestore.mini.service.impl;

import com.keyvaluestore.mini.model.Request;
import com.keyvaluestore.mini.service.PrimaryStoreService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** The type Primary store service. */
public class PrimaryStoreServiceImpl implements PrimaryStoreService {

	private static final Map<String, Map<String, Object>> primaryMap = new ConcurrentHashMap<>();

	public void save(Request request) {
		Map<String, Object> secondaryMap = new HashMap<>();
		secondaryMap.put(request.getAttrKey(), request.getAttrValue());
		primaryMap.put(request.getKey(), secondaryMap);
	}

	@Override
	public Map<String, Object> get(String key) {
		return primaryMap.get(key)
;	}

	@Override
	public void remove(Request request) {
		if(primaryMap.containsKey(request.getKey()))
			primaryMap.remove(request.getKey());
	}
}
