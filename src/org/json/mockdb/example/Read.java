package org.json.mockdb.example;

import java.io.IOException;

import org.json.mockdb.MockAction;

public class Read {

	public static void main(String[] args) throws IOException {
		MockExample example = new MockExample();
		example.setId("250aa500-6bfd-490c-83fd-5eb5778700c4");
		
		example = MockAction.read(example);
		System.out.println(example.getSomeList());
	}
}
