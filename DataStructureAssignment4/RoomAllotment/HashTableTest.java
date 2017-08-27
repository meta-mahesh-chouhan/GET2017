package com.metacue.hashmap;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Test class for Hash Table
 * @author Mahesh Chouhan
 *
 */
public class HashTableTest {

	@Test
	public void putTest() {
		HashTable<Integer, String> hashTable = new HashTable<>(5);
		hashTable.put(12, "Mahesh");
		hashTable.put(13, "Chouhan");

		assertEquals("Mahesh", hashTable.get(12));
	}

	@Test
	public void getTestPass() {

		HashTable<Integer, String> hashTable = new HashTable<>(5);
		hashTable.put(12, "Mahesh");
		hashTable.put(13, "Chouhan");

		assertEquals("Chouhan", hashTable.get(13));

	}

	@Test
	public void getTestFail() {

		HashTable<Integer, String> hashTable = new HashTable<>(5);
		hashTable.put(12, "Mahesh");
		hashTable.put(13, "Chouhan");

		assertNotEquals("Chouhan", hashTable.get(12));

	}

	@Test
	public void containsKeyPass() {
		HashTable<Integer, String> hashTable = new HashTable<>(5);
		hashTable.put(12, "Mahesh");
		hashTable.put(13, "Chouhan");

		assertTrue(hashTable.containsKey(12));

	}

	@Test
	public void containsKeyFail() {
		HashTable<Integer, String> hashTable = new HashTable<>(5);
		hashTable.put(12, "Mahesh");
		hashTable.put(13, "Chouhan");

		assertFalse(hashTable.containsKey(15));

	}

	@Test
	public void isFullPass() {

		HashTable<Integer, String> hashTable = new HashTable<>(3);

		hashTable.put(12, "Mahesh");
		hashTable.put(13, "Chouhan");
		hashTable.put(14, "Udit");

		assertTrue(hashTable.isFull());

	}

	@Test
	public void isFullFail() {

		HashTable<Integer, String> hashTable = new HashTable<>(3);
		hashTable.put(12, "Mahesh");
		hashTable.put(14, "Udit");

		assertFalse(hashTable.isFull());

	}

	@Test
	public void searchPass() {

		HashTable<Integer, String> hashTable = new HashTable<>(3);
		hashTable.put(12, "Mahesh");
		hashTable.put(14, "Udit");

		assertEquals(0, hashTable.search("Mahesh"));
	}

	@Test
	public void searchFail() {

		HashTable<Integer, String> hashTable = new HashTable<>(3);
		hashTable.put(12, "Mahesh");
		hashTable.put(14, "Udit");

		assertEquals(-1, hashTable.search("Gaurav"));
	}
}
