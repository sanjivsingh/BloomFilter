package com.sanjivsingh.bloomfilter;

import java.nio.charset.Charset;

import com.sanjivsingh.bloomfilter.array.BitArray;
import com.sanjivsingh.bloomfilter.hashalgo.HashingAlgo;
import com.sanjivsingh.bloomfilter.hashalgo.Murmur3HashAlgo;

/**
 * The Class AbstractBloomFilter.
 *
 * @param <T> the generic type
 */
public abstract class AbstractBloomFilter<T> implements BloomFilter<T> {
  
  /** The bit array. */
  protected BitArray bitArray;
  
  /** The number of hash functions. */
  protected int numberOfHashFunctions;
  
  /** The hasher. */
  protected HashingAlgo hasher;
  
  /** The number of bits. */
  protected int numberOfBits;
  
  /**
   * Instantiates a new abstract bloom filter.
   */
  protected AbstractBloomFilter() {
    this(64, 2, new Murmur3HashAlgo());
  }
  
  /**
   * Instantiates a new abstract bloom filter.
   *
   * @param numberOfBits the number of bits
   * @param numberOfHashFunctions the number of hash functions
   * @param hasher the hasher
   */
  protected AbstractBloomFilter(int numberOfBits, int numberOfHashFunctions, HashingAlgo hasher) {
    
    this.numberOfBits = numberOfBits;
    this.numberOfHashFunctions = numberOfHashFunctions;
    this.bitArray = createBitArray(this.numberOfBits);
    if (hasher != null) {
      this.hasher = hasher;
    }
  }
  
  /**
   * Creates the bit array.
   *
   * @param numberOfBits the number of bits
   * @return the bit array
   */
  protected abstract BitArray createBitArray(int numberOfBits);
  
  /**
   * Adds the.
   *
   * @param value the value
   * @return true, if successful
   */
  @Override
  public boolean add(T value) {
    if (value == null) {
      return false;
    }
    return add(value.toString().getBytes(Charset.defaultCharset()));
    
  }
  
  /**
   * Adds the.
   *
   * @param bytes the bytes
   * @return true, if successful
   */
  @Override
  public boolean add(byte[] bytes) {
    long hash = getHash(bytes);
    int hash1 = (int) hash;
    int hash2 = (int) (hash >>> 32);
    
    boolean bitsChanged = false;
    for (int i = 1; i <= this.numberOfHashFunctions; i++) {
      int nextHash = hash1 + i * hash2;
      if (nextHash < 0) {
        nextHash = ~nextHash;
      }
      bitsChanged |= this.bitArray.setBit(nextHash % this.bitArray.bitSize());
    }
    
    return bitsChanged;
    
  }
  
  /**
   * Contains.
   *
   * @param bytes the bytes
   * @return true, if successful
   */
  @Override
  public boolean contains(byte[] bytes) {
    long hash = getHash(bytes);
    int hash1 = (int) hash;
    int hash2 = (int) (hash >>> 32);
    for (int i = 1; i <= this.numberOfHashFunctions; i++) {
      int nextHash = hash1 + i * hash2;
      if (nextHash < 0) {
        nextHash = ~nextHash;
      }
      if (!this.bitArray.getBit(nextHash % this.bitArray.bitSize())) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * Contains.
   *
   * @param value the value
   * @return true, if successful
   */
  @Override
  public boolean contains(T value) {
    if (value == null) {
      return false;
    }
    
    return contains(value.toString().getBytes(Charset.defaultCharset()));
  }
  
  /**
   * Gets the hash.
   *
   * @param bytes the bytes
   * @return the hash
   */
  protected long getHash(byte[] bytes) {
    if (bytes == null) {
      throw new IllegalArgumentException("Bytes cannot be null");
    }
    return this.hasher.hash(bytes);
    
  }
  
}
