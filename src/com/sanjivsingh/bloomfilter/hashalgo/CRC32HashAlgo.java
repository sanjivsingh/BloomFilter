package com.sanjivsingh.bloomfilter.hashalgo;

import java.util.zip.CRC32;

/**
 * The Class CRC32HashAlgo.
 */
public class CRC32HashAlgo implements HashingAlgo {
  
  /**
   * Hash.
   *
   * @param bytes the bytes
   * @return the long
   */
  @Override
  public long hash(byte[] bytes) {
    CRC32 crc32 = new CRC32();
    crc32.update(bytes);
    return crc32.getValue();
  }
  
}
