package org.json.mockdb.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.mockdb.MockAction;

public class Create {

	public static void main(String[] args) throws IOException {

		MockExample example = new MockExample();
		example.setId(UUID.randomUUID().toString());
		example.setSomeBoolean(true);
		example.setSomeInt((int) (Math.random() * 100));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add((int) (Math.random() * 100));
		list.add((int) (Math.random() * 100));
		list.add((int) (Math.random() * 100));
		list.add((int) (Math.random() * 100));
		list.add((int) (Math.random() * 100));
		example.setSomeList(list);
		
		MockAction.create(example);
		
	}

}
