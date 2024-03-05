package com.sanjivsingh.bloomfilter.hashalgo;

import org.apache.commons.codec.digest.MurmurHash3;

/**
 * The Class Murmur3HashAlgo.
 */
public class Murmur3HashAlgo implements HashingAlgo {
  
  /**
   * Hash.
   *
   * @param bytes the bytes
   * @return the long
   */
  @Override
  public long hash(byte[] bytes) {
    return MurmurHash3.hash64(bytes);
  }
  
}
