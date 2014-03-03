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
package no.uib.pviz.core;

import no.uib.pviz.core.ManagedArray;
import no.uib.pviz.core.ArrayManager;

class ByteSetArrayManager implements ArrayManager {
	static final int BYTE_MAX = 0xff;
  byte dense[];
  byte sparse[];
  int n;
  ManagedArray m;
  
  ByteSetArrayManager(ManagedArray m) {
    dense  = new byte[BYTE_MAX];
    sparse = new byte[BYTE_MAX];
    n = 0;
    this.m = m;
  }

  private int mask(int i) {
  	return i&BYTE_MAX;
  }

  public boolean member(int i) {
  	return sparse[i] < n && dense[sparse[i]] == i;
  }
  
  public int insert(int i) {
  	dense[n]  = (byte)mask(i);
  	sparse[i] = (byte)mask(n);
  	return n++;
  }

  public boolean remove(int i) {
  	if(member(i)) {
  	  int removed = mask(sparse[i]);
  	  int end = mask(dense[n-1]);
  	  dense[removed] = (byte)mask(end);
  	  sparse[end] = (byte)mask(removed);
  	  m.move(removed,n-1);
  	  n--;
  	  return true;
  	} 
  	return false;
  }

  public int get(int i) {
    return dense[sparse[mask(i)]];
  }

  public int size() {
  	return n;
  }



}