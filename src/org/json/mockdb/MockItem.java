package org.json.mockdb;

public interface MockItem {

	/**
	 * Returns the file name without extension.
	 * @return File name.
	 */
	abstract String getFileName();
	
	abstract void setId(String id);
	
	abstract String getId();
}
