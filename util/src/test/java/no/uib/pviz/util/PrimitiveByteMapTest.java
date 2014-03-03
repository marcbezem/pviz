/*
 * Copyright (C) 2012 Andreas Halle
 * Copyright (C) 2014 Ole Jørgen Abusdal
 *
 * This file is part of pplex.
 *
 * pplex is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * pplex is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public license
 * along with pplex. If not, see <http://www.gnu.org/licenses/>.
 */


package no.uib.pviz.util;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for {@link no.uib.pviz.util.PrimitiveByteMap}.
 *
 * @author ole.jorgen.abusdal@gmail.com (Ole Jørgen Abusdal)
 */
@RunWith(JUnit4.class)
public class PrimitiveByteMapTest {
  
  @Test
  public void put() {
  	PrimitiveIntMap m = new PrimitiveByteMap();
  	m.put(0,200);
  	m.put(1,231);
  	assertEquals(200,m.get(0));
  	assertEquals(231,m.get(1));
  }

  @Test
  public void size() {
    PrimitiveIntMap m = new PrimitiveByteMap();
  	assertTrue(m.size()==0);
  	m.put(0,5);
  	assertTrue(m.size()==1);
  	m.put(1,6);
  	assertTrue(m.size()==2);
  }

  @Test
  public void remove() {
    PrimitiveIntMap m = new PrimitiveByteMap();
    m.put(0,234);
    m.put(1,100);
    assertEquals(234,m.remove(0));
    assertEquals(100,m.remove(1));
  }

  @Test
  public void containsKey() {
    PrimitiveIntMap m = new PrimitiveByteMap();
    m.put(0,234);
    m.put(1,100);
    m.put(2,123);
    assertTrue(m.containsKey(0));
    assertTrue(m.containsKey(1));
    assertTrue(m.containsKey(2));
    assertFalse(m.containsKey(3));
  }
  
}