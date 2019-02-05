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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mowitnow.Direction;
import com.mowitnow.Mower;
import com.mowitnow.Order;

@RunWith(JUnit4.class)
public class MowerTest {

	@Test
	public void moveClockwiseManyTimes() {
		Mower mower = new Mower(0, 0, Direction.NORTH);
		// rotate 4 times clockwise
		mower.moveClockwise();
		mower.moveClockwise();
		mower.moveClockwise();
		mower.moveClockwise();

		assertEquals(Direction.NORTH, mower.getDirection());
	}

	@Test
	public void moveAnticlockwiseManyTimes() {
		Mower mower = new Mower(0, 0, Direction.NORTH);
		// rotate 4 times clockwise
		mower.moveAnticlockwise();
		mower.moveAnticlockwise();
		mower.moveAnticlockwise();
		mower.moveAnticlockwise();

		assertEquals(Direction.NORTH, mower.getDirection());
	}

	@Test
	public void Object_toString() {
		assertEquals("Mower [x=1, y=3, direction=N]", new Mower(1, 3, Direction.NORTH).toString());
	}

	@Test
	public void Object_equals() {
		Mower ref = new Mower(1, 3, Direction.NORTH);
		assertEquals(ref, ref);
		assertEquals(new Mower(1, 3, Direction.NORTH), ref);

		assertFalse(ref.equals(null));
		assertFalse(ref.equals(new Integer(1)));

		assertNotEquals(new Mower(1, 5, null), ref);
		assertNotEquals(new Mower(1, 5, Direction.NORTH), ref);
		assertNotEquals(new Mower(2, 5, Direction.NORTH), ref);
		assertNotEquals(new Mower(1, 5, Direction.EAST), ref);
	}

	@Test
	public void Object_hashCode() {
		assertEquals(new Mower(1, 3, Direction.NORTH).hashCode(), new Mower(1, 3, Direction.NORTH).hashCode());
	}

	@Test
	public void useCase1() {
		Mower mower = new Mower(1, 2, Direction.NORTH);
		assertEquals(new Mower(1, 3, Direction.NORTH), moveWithOrders(mower, "GAGAGAGAA", 6, 6));
	}

	@Test
	public void useCase2() {
		Mower mower = new Mower(3, 3, Direction.EAST);
		assertEquals(new Mower(5, 1, Direction.EAST), moveWithOrders(mower, "AADAADADDA", 6, 6));
	}

	private static Mower moveWithOrders(Mower mower, String ordersRaw, int n, int m) {
		// parse orders
		Order[] orders = new Order[ordersRaw.length()];
		for (int index = 0; index < ordersRaw.length(); index++) {
			orders[index] = Order.parse(ordersRaw.charAt(index));
		}
		// for each orders, make the action
		for (Order order : orders) {
			order.animate(mower, n, m);
		}
		return mower;
	}
}