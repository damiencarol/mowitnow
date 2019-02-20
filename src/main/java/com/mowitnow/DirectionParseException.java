/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.mowitnow;

public class DirectionParseException extends Exception {
  private static final long serialVersionUID = 5814448575011531479L;
  private final char value;

  /**
   * @return the value of the error token
   */
  public char getValue() {
    return value;
  }

  /**
   * @param value2 Token in error
   */
  public DirectionParseException(char value2) {
    super(String.format("Unable to parse '%s' for enum %s", value2, Direction.class));
    this.value = value2;
  }
}
