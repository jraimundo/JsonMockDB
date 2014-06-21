/**
 * 
 */
package org.json.mockdb.utils;

import java.lang.reflect.Type;
import java.math.BigDecimal;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 
 *
 */
public class BigDecimalSerialiser implements JsonSerializer<BigDecimal> {

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(BigDecimal src, Type typeOfSrc, JsonSerializationContext arg2) {
		return new JsonPrimitive(src.setScale(3, BigDecimal.ROUND_HALF_UP));
	}

}
