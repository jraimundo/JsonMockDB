/**
 * 
 */
package org.json.mockdb.utils;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 
 *
 */
public class BooleanSerialiser implements JsonSerializer<Boolean>, JsonDeserializer<Boolean>{

	/* (non-Javadoc)
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext arg2) {	
		return new JsonPrimitive(src ? 1: 0);
	}

	/* (non-Javadoc)
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Boolean deserialize(JsonElement elem, Type typeOfSrc, JsonDeserializationContext arg2) throws JsonParseException {
		return elem.getAsInt() == 1 ? true : false;
	}

}
