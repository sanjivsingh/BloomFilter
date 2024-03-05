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
