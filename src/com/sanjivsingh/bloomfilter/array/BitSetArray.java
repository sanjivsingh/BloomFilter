/*
 * Copyright 2024 Sanjiv Singh
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

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
