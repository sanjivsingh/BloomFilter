package com.sanjivsingh.bloomfilter.hashalgo;

/**
 * The Interface HashingAlgo.
 */
public interface HashingAlgo {
  
  /**
   * Hash.
   *
   * @param bytes the bytes
   * @return the long
   */
  public long hash(byte[] bytes);
  
}
