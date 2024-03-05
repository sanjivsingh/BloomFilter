package com.sanjivsingh.bloomfilter.array;

import java.io.Closeable;

/**
 * The Interface BitArray.
 */
public interface BitArray extends Closeable {


  /**
   * Gets the bit.
   *
   * @param index the index
   * @return the bit
   */
  public boolean getBit(int index);
  

  /**
   * Sets the bit.
   *
   * @param index the index
   * @return true, if successful
   */
  public boolean setBit(int index);


  /**
   * Bit size.
   *
   * @return the int
   */
  public int bitSize();
  
}
