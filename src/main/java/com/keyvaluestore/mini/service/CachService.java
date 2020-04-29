package com.keyvaluestore.mini.service;

import com.keyvaluestore.mini.model.Request;

import java.util.List;
import java.util.Map;

/** The interface Cach service. */
public interface CachService {

  /**
   * Insert key.
   *
   * @param request the request
   */
  void insertKey(Request request);

  /**
   * Search map.
   *
   * @param key the key
   * @return the map
   */
  // @todo: Should return valid types
  Map<String, Object> search(String key);

  /**
   * Search secondary list.
   *
   * @param attrKey the attr key
   * @param attrValue the attr value
   * @return the list
   */
  List<String> searchSecondary(String attrKey, Object attrValue);

  /**
   * Delete key.
   *
   * @param request the request
   */
  void deleteKey(Request request);
}
