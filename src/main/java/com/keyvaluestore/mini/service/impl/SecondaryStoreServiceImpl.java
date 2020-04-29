package com.keyvaluestore.mini.service.impl;

import com.keyvaluestore.mini.model.Request;
import com.keyvaluestore.mini.service.SecondaryStoreService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** The type Secondary store service. */
public class SecondaryStoreServiceImpl implements SecondaryStoreService {

	private static final Map<String, List<String>> secondaryMap = new ConcurrentHashMap<>();

	@Override
	public void save(Request request) {
		/**
		 * @NOTE : We use HashCode of the Object Here
		 */
		String key = getKey(request.getAttrKey(), request.getAttrValue());
		List<String> existingKeys = secondaryMap.getOrDefault(key, new ArrayList<>());
		existingKeys.add(request.getKey());
		secondaryMap.put(key, existingKeys);
	}

	@Override
	public List<String> get(String attrKey, Object attrValue) {
		String key = getKey(attrKey, attrValue);
		return secondaryMap.get(key);
	}

	@Override
	public void remove(Request request) {
		String key = getKey(request.getAttrKey(), request.getAttrValue());
		if(secondaryMap.containsKey(key))
			secondaryMap.remove(key);
	}

	private String getKey(String attrKey, Object attrValue){
		return attrKey + attrValue.hashCode();
	}

}
