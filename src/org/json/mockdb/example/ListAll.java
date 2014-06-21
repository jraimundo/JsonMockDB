package org.json.mockdb.example;

import java.io.IOException;
import java.util.List;

import org.json.mockdb.MockAction;

public class ListAll {

	public static void main(String[] args) throws IOException {

		MockExample example = new MockExample();
		List<MockExample> exampleList = MockAction.listAll(example);
		
		System.out.println(exampleList);
	}

}
