package org.json.mockdb.example;

import java.io.IOException;

import org.json.mockdb.MockAction;

public class Update {

	public static void main(String[] args) throws IOException {
		
		MockExample example = new MockExample();
		example.setId("fa0d18c8-2da0-49b5-a3be-8249a7d3b2b7");
		example = MockAction.read(example);
		System.out.println(example.getSomeInt());
		
		example.setSomeInt((int) (Math.random() * 100));
		MockAction.update(example);
		example = MockAction.read(example);
		System.out.println(example.getSomeInt());
	}
}
