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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DirectionParseExceptionTest {

  @Test
  public void getAnticlockwise() {
    assertEquals(Direction.WEST, Direction.NORTH.getAnticlockwise());
  }

  @Test
  public void getClockwise() {
    assertEquals(Direction.EAST, Direction.NORTH.getClockwise());
  }

  @Test
  public void parse() throws DirectionParseException {
    assertEquals(Direction.NORTH, Direction.parse('N'));

    assertEquals(Direction.NORTH, Direction.parse("N"));
    assertEquals(Direction.NORTH, Direction.parse("n"));
    assertEquals(Direction.NORTH, Direction.parse("North"));
    assertEquals(Direction.NORTH, Direction.parse("NORTH"));
  }

  @Test(expected = DirectionParseException.class)
  public void parseNot() throws DirectionParseException {
    Direction.parse("??????");
  }

  @Test
  public void throwable() {
    String message = "message";
    Throwable innerException = new RuntimeException(message);
    try {
      throw new DirectionParseException(innerException);
    } catch (DirectionParseException exception) {
      assertEquals(innerException, exception.getCause());
      return;
    }
  }

  @Test
  public void message() {
    String reason = "reason";
    try {
      throw new DirectionParseException(reason);
    } catch (DirectionParseException exception) {
      assertEquals(reason, exception.getMessage());
      return;
    }
  }

  @Test
  public void throwableMessage() {
    String reason = "reason";
    String message = "message";
    Throwable innerException = new RuntimeException(message);
    try {
      throw new DirectionParseException(reason, innerException);
    } catch (DirectionParseException exception) {
      assertEquals(innerException, exception.getCause());
      return;
    }
  }

  @Test
  public void throwableMessageToken() {
    String reason = "reason";
    String message = "message";
    char token = 'x';
    Throwable innerException = new RuntimeException(message);
    try {
      throw new DirectionParseException(reason, token, innerException);
    } catch (DirectionParseException exception) {
      assertEquals(reason, exception.getMessage());
      assertEquals(token, exception.getValue());
      assertEquals(innerException, exception.getCause());
      return;
    }
  }
}