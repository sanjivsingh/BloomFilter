package com.sanjivsingh.bloomfilter;

/**
 * The Interface BloomFilter.
 *
 * @param <T> the generic type
 */
public interface BloomFilter<T> {
  
  /**
   * Adds the.
   *
   * @param value the value
   * @return true, if successful
   */
  public boolean add(T value);
  
  /**
   * Adds the.
   *
   * @param t the t
   * @return true, if successful
   */
  public boolean add(byte[] t);
  
  /**
   * Contains.
   *
   * @param value the value
   * @return true, if successful
   */
  public boolean contains(byte[] value);
  
  /**
   * Contains.
   *
   * @param value the value
   * @return true, if successful
   */
  public boolean contains(T value);
  
}
