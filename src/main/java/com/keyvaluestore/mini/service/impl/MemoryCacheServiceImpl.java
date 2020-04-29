package com.keyvaluestore.mini.service.impl;

import com.keyvaluestore.mini.model.Request;
import com.keyvaluestore.mini.service.CachService;
import com.keyvaluestore.mini.service.DataTypeStoreService;
import com.keyvaluestore.mini.service.PrimaryStoreService;
import com.keyvaluestore.mini.service.SecondaryStoreService;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

/** The type Memory cache service. */
public class MemoryCacheServiceImpl implements CachService {

	@NonNull
	private PrimaryStoreService primaryKeyService;

	@NonNull
	private DataTypeStoreService dataTypeStoreService;

	@NonNull
	private SecondaryStoreService secondaryStoreService;

  /** Instantiates a new Memory cache service. */
  public MemoryCacheServiceImpl() {
		primaryKeyService = new PrimaryStoreServiceImpl();
		dataTypeStoreService = new DataTypeStoreServiceImpl();
		secondaryStoreService = new SecondaryStoreServiceImpl();
	}

	@Override
	public void insertKey(Request request) {
		// Save Data Type
		dataTypeStoreService.save(request);

		// Save primary Key
		primaryKeyService.save(request);

		// Save Secondary Key
		secondaryStoreService.save(request);
	}

	@Override
	public Map<String, Object> search(String key) {
		return primaryKeyService.get(key);
	}

	@Override
	public List<String> searchSecondary(String attrKey, Object attrValue) {
		return secondaryStoreService.get(attrKey, attrValue);
	}

	@Override
	public void deleteKey(Request request) {
		dataTypeStoreService.remove(request);
		primaryKeyService.remove(request);
		secondaryStoreService.remove(request);
	}
}