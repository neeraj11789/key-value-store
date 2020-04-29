package com.keyvaluestore.mini.service;

import com.keyvaluestore.mini.model.Request;

import java.util.List;

/** The interface Secondary store service. */
public interface SecondaryStoreService {
  /**
   * Save.
   *
   * @param request the request
   */
  void save(Request request);

  /**
   * Get list.
   *
   * @param attrKey the attr key
   * @param attrValue the attr value
   * @return the list
   */
  List<String> get(String attrKey, Object attrValue);

  /**
   * Remove.
   *
   * @param request the request
   */
  void remove(Request request);
}
