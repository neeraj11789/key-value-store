package com.keyvaluestore.mini.model;

import lombok.*;

/** The type Request. */
@Getter
@Setter
@RequiredArgsConstructor
public class Request {

	@NonNull
	private String key;

	@NonNull
	private String attrKey;

	@NonNull
	private Object attrValue;

  /**
   * Detect data type data type.
   *
   * @return the data type
   */
  public DataType detectDataType() {
		if(attrValue instanceof Boolean)
		  return DataType.BOOL;
	  else if(attrValue instanceof Integer)
		  return DataType.INT;
	  else if(attrValue instanceof Double)
		  return DataType.DOUBLE;
	  else return DataType.STRING;
	}
}
