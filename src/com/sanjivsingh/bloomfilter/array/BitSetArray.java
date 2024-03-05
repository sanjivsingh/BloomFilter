package com.sanjivsingh.bloomfilter.array;

import java.io.IOException;
import java.util.BitSet;

/**
 * The Class BitSetArray.
 */
public class BitSetArray implements BitArray {
  
  /** The bit set. */
  final BitSet bitSet;
  
  /** The size. */
  final int size;
  
  /**
   * Instantiates a new bit set array.
   *
   * @param numBits the num bits
   */
  public BitSetArray(int numBits) {
    this.bitSet = new BitSet(numBits);
    this.size = this.bitSet.size();
  }
  
  /**
   * Gets the bit.
   *
   * @param index the index
   * @return the bit
   */
  @Override
  public boolean getBit(int index) {
    return this.bitSet.get(index);
  }
  
  /**
   * Sets the bit.
   *
   * @param index the index
   * @return true, if successful
   */
  @Override
  public boolean setBit(int index) {
    this.bitSet.set(index);
    return true;
  }
  
  /**
   * Close.
   *
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @Override
  public void close() throws IOException {
  }

  /**
   * Bit size.
   *
   * @return the int
   */
  @Override
  public int bitSize() {
    return this.size;
  }
  
}
