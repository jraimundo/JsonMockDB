package org.json.mockdb.utils;

import java.math.BigDecimal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

	/**
	 * Creates a Gson instance based on the following configuration: dateFormat = "yyyy-MM-dd'T'HH:mm:ss"
	 * @return an instance of Gson configured with the above options
	 */
	public static Gson createGson() {
		GsonBuilder gsonBld = new GsonBuilder();
		gsonBld.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		gsonBld.registerTypeAdapter(BigDecimal.class, new BigDecimalSerialiser());
		gsonBld.registerTypeAdapter(Boolean.class, new BooleanSerialiser());
		Gson gson = gsonBld.create();
		return gson;
	}
}
