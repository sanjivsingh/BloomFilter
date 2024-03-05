package com.sanjivsingh.bloomfilter;

import com.sanjivsingh.bloomfilter.array.BitArray;
import com.sanjivsingh.bloomfilter.array.BitSetArray;

/**
 * The Class NonPersistentBloomFilter.
 *
 * @param <T> the generic type
 */
public class NonPersistentBloomFilter<T> extends AbstractBloomFilter<T> {

	/**
	 * Instantiates a new non persistent bloom filter.
	 */
	public NonPersistentBloomFilter() {
		super();
	}

	/**
	 * Creates the bit array.
	 *
	 * @param numberOfBits the number of bits
	 * @return the bit array
	 */
	@Override
	protected BitArray createBitArray(int numberOfBits) {
		return new BitSetArray(numberOfBits);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		BloomFilter<String> bloomFilter = new NonPersistentBloomFilter<>();
		bloomFilter.add("1");
		bloomFilter.add("2");
		bloomFilter.add("3");
		bloomFilter.add("4");
		bloomFilter.add("5");
		bloomFilter.add("6");
		bloomFilter.add("7");
		bloomFilter.add("7");

		bloomFilter.add("10");
		bloomFilter.add("11");
		bloomFilter.add("12");

		bloomFilter.add("31");

		boolean contains = bloomFilter.contains("21");
		System.out.println(contains);
		contains = bloomFilter.contains("20");
		System.out.println(contains);

	}

}
