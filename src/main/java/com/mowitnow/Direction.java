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

public enum Direction {
	NORTH('N'), EAST('E'), SOUTH('S'), WEST('W');

	private final char inner;
	private Direction clockwise;
	private Direction anticlockwise;

	static {
		NORTH.clockwise = EAST;
		EAST.clockwise = SOUTH;
		SOUTH.clockwise = WEST;
		WEST.clockwise = NORTH;
		NORTH.anticlockwise = WEST;
		EAST.anticlockwise = NORTH;
		SOUTH.anticlockwise = EAST;
		WEST.anticlockwise = SOUTH;
	}

	Direction(final char val) {
		inner = val;
	}

	public String toString() {
		return String.valueOf(inner);
	}

	public static Direction parse(char val) {
		for (Direction d : Direction.values()) {
			if (val == d.inner) {
				return d;
			}
		}
		String msg = String.format("Unable to parse '%s' for enum %s", val, Direction.class);
		throw new RuntimeException(msg);
	}

	public static Direction parse(String val) {
		return parse(val.toUpperCase().charAt(0));
	}

	public Direction getClockwise() {
		return clockwise;
	}

	public Direction getAnticlockwise() {
		return anticlockwise;
	}
}
