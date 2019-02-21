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

public enum Order {
  GAUCHE('G') {
    @Override
    public void animate(Mower mower, int n, int m) {
      mower.moveAnticlockwise();
    }
  },
  DROITE('D') {
    @Override
    public void animate(Mower mower, int n, int m) {
      mower.moveClockwise();
    }
  },
  AVANCE('A') {
    @Override
    public void animate(Mower mower, int n, int m) {
      mower.moveForward(n, m);
    }
  };

  private final char inner;

  Order(final char val) {
    inner = val;
  }

  @Override
  public String toString() {
    return String.valueOf(inner);
  }

  /**
   * Parses the character argument as an order.
   *
   * @param value a {@code char} containing the {@code Order} representation to be
   *              parsed
   * @return the order value represented by the argument.
   * @throws OrderParseException if the char is not a parsable order.
   */
  public static Order parse(final char value) throws OrderParseException {
    for (Order d : Order.values()) {
      if (value == d.inner) {
        return d;
      }
    }
    throw new OrderParseException(value);
  }

  /**
   * Parses the string argument as an order.
   *
   * @param val a {@code String} containing the {@code Order} representation to be
   *            parsed
   * @return the order value represented by the argument.
   * @throws OrderParseException if the string does not contain a parsable order.
   */
  public static Order parse(final String val) throws OrderParseException {
    return parse(val.toUpperCase().charAt(0));
  }

  /**
   * Mode a {@code Mower} according to an order.
   *
   * @param mower Mower to move
   * @param n     Weight size of the area
   * @param m     Height size of the area
   */
  abstract void animate(Mower mower, int n, int m);
}
