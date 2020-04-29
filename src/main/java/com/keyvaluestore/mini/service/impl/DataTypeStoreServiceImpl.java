package com.keyvaluestore.mini.service.impl;

import com.keyvaluestore.mini.model.DataType;
import com.keyvaluestore.mini.model.Request;
import com.keyvaluestore.mini.service.DataTypeStoreService;
import com.keyvaluestore.mini.util.Constants;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/** The type Data type store service. */
public class DataTypeStoreServiceImpl implements DataTypeStoreService {

	private static final Map<String, DataType> dataStoreMap = new ConcurrentHashMap<>();

	@Override
	public void save(Request request) {

		DataType dataType = request.detectDataType();

		if(!isValid(request, dataType))
			throw new IllegalArgumentException(Constants.INVALID_DATATYPE);

		// ignore if present
		if (dataStoreMap.containsKey(request.getAttrKey())) return;

		dataStoreMap.put(request.getAttrKey(), dataType);
	}

	@Override
	public void remove(Request request) {
		if (dataStoreMap.containsKey(request.getAttrKey()))
			dataStoreMap.remove(request.getAttrKey());
	}

	private boolean isValid(Request request, DataType dataType) {
		if (dataStoreMap.containsKey(request.getAttrKey())){
			DataType oldDataType = dataStoreMap.get(request.getAttrKey());
			return oldDataType.equals(dataType);
		}
		return true;
	}
}
