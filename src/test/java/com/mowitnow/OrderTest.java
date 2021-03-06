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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mowitnow.Order;

@RunWith(JUnit4.class)
public class OrderTest {
  @Test
  public void parse() throws OrderParseException {
    assertEquals(Order.AVANCE, Order.parse('A'));

    assertEquals(Order.AVANCE, Order.parse("A"));
    assertEquals(Order.AVANCE, Order.parse("a"));
    assertEquals(Order.AVANCE, Order.parse("avance"));
    assertEquals(Order.AVANCE, Order.parse("avance bouricot!"));
  }

  @Test
  public void Object_toString() {
    assertEquals("A", Order.AVANCE.toString());
  }

  @Test(expected = OrderParseException.class)
  public void parseNot() throws OrderParseException {
    Order.parse("??????");
  }

  @Test
  public void parseNotEmpty() throws OrderParseException {
    try {
      Order.parse("?");
    } catch (OrderParseException exception) {
      assertEquals('?', exception.getValue());
      return;
    }
    fail();
  }
}