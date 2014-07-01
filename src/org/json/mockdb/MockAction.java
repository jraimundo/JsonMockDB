package org.json.mockdb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.json.mockdb.utils.GsonUtils;

import com.google.gson.Gson;

public class MockAction {
	
	private static final String FILE_EXTENSION = ".txt";
	private static final String FOLDER_NAME = "MockDB";

	/**
	 * Appends an object record on a file named after MockItem.getFileName(). 
	 * @param item
	 * @throws IOException
	 */
	public static <M extends MockItem> void create(M item) throws IOException {
		Gson gson = GsonUtils.createGson();
		String json = gson.toJson(item);
		
		PrintWriter writer = new PrintWriter(new FileWriter(getFile(item.getFileName()), true));
		writer.println(json);
		writer.close();
	}
	
	/**
	 * Reads an item from the associated file. The id must match with an existing one.
	 * @param item - item containing the id to read.
	 * @return - MockItem object with the input id. null if not found. 
	 * @throws IOException
	 */
	public static <M extends MockItem> M read(M item) throws IOException {
		List<M> itemsList = listAll(item);
		
		if (item.getId() != null) {
			
			for (M i : itemsList) {
				String id = i.getId();
				if (id != null && id.equals(item.getId())) {
					return i;
				}
			}
			
		}
		
		return null;
	}
	
	
	/**
	 * Updates a record in the file. The id of the new item must match with an existing one.
	 * @param item - Updated item.
	 * @throws IOException
	 */
	public static <M extends MockItem> void update(M item) throws IOException {
		List<M> itemsList = listAll(item);
		boolean itemFound = false;

		if (item.getId() != null) {
			
			int index = 0;
			for (M i : itemsList) {
				String id = i.getId();
				if (id != null && id.equals(item.getId())) {
					itemsList.set(index, item);
					itemFound = true;
					break;
				}
				
				index++;
			}
			
			if (!itemFound) {
				System.out.println("Item to delete not found!");
			} else {
				overrideFile(itemsList, item.getFileName());
			}
			
		}
	}
	
	/**
	 * Deletes an item from the file. The id must match with an existing one.
	 * @param item - item containing the id to read.
	 * @throws IOException
	 */
	public static <M extends MockItem> void delete(M item) throws IOException {
		List<M> itemsList = listAll(item);
		boolean itemFound = false;
		
		if (item.getId() != null) {
			
			int index = 0;
			for (M i : itemsList) {
				String id = i.getId();
				if (id != null && id.equals(item.getId())) {
					itemsList.remove(index);
					itemFound = true;
					break;
				}
				
				index++;
			}
			
			if (!itemFound) {
				System.out.println("Item to delete not found!");
			} else {
				overrideFile(itemsList, item.getFileName());
			}
		
		}
		
	}
	
	/**
	 * Reads a file associated with a MockItem type to extracts all the items as a List.
	 * @param itemType - Item type to determine the fileName to read.
	 * @return List of all objects stored in file.
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static <M extends MockItem> List<M> listAll(M itemType) throws IOException {
		List<M> itemsList = new ArrayList<M>();
		BufferedReader br = new BufferedReader(new FileReader(getFile(itemType.getFileName())));
		try {
			Gson gson = GsonUtils.createGson();
			
			String line = br.readLine();
			while (line != null) {
				itemsList.add((M) gson.fromJson(line, itemType.getClass()));
				line = br.readLine();
			}
		} finally {
			br.close();
		}
		
		return itemsList;
	}
	
	/**
	 * Overrides the existing file with a list of new objects converted to JSON.
	 * @param itemsList - List of object to store.
	 * @param fileName - File name to override.
	 * @throws IOException
	 */
	private static <M extends MockItem> void overrideFile(List<M> itemsList, String fileName) throws IOException {
		Gson gson = GsonUtils.createGson();
		PrintWriter writer = new PrintWriter(new FileWriter(getFile(fileName)));
		
		try {
			for (M item : itemsList) {
				String json = gson.toJson(item);
				writer.println(json);
			}
		} finally {
			writer.close();
		}
	}
	
	/**
	 * Returns associated with the file name. If the folder doesn't existis it will be created.
	 * @param fileName - the file name.
	 * @return The File object.
	 * @throws IOException 
	 */
	private static File getFile(String fileName) throws IOException {
		
		if (!FOLDER_NAME.equals("")) {
			File folder = new File(FOLDER_NAME);
			if (!folder.exists())
				folder.mkdirs();
			
			return checkFile(FOLDER_NAME + "//" + fileName + FILE_EXTENSION);
		} else {
			return checkFile(fileName + FILE_EXTENSION);
		}
		
	}
	
	/**
	 * Check if a file for the pathname exists. If not it will be crated. 
	 * @param pathname - File pathname.
	 * @return The File object.
	 * @throws IOException
	 */
	private static File checkFile(String pathname) throws IOException {
		
		File file = new File(pathname);
		if (!file.exists())
			file.createNewFile();
		
		return file;
	}
}
