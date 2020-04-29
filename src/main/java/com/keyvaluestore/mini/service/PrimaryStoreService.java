package com.keyvaluestore.mini.service;

import com.keyvaluestore.mini.model.Request;

import java.util.Map;

/** The interface Primary store service. */
public interface PrimaryStoreService {

  /**
   * Save.
   *
   * @param request the request
   */
  void save(Request request);

  /**
   * Get map.
   *
   * @param key the key
   * @return the map
   */
  Map<String, Object> get(String key);

  /**
   * Remove.
   *
   * @param request the request
   */
  void remove(Request request);
}
