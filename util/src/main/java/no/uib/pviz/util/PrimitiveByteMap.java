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

import java.lang.Long;

public class PrimitiveByteMap implements PrimitiveIntMap {

static final int BYTE_MAX = 0xff;
static final int BIT_SET_SIZE = BYTE_MAX/Long.SIZE; 

	byte[] values;
	long[] bitset;
	int n;

	public PrimitiveByteMap(){
  	values = new byte[BYTE_MAX];
  	bitset = new long[BIT_SET_SIZE];
  	n = 0;
  }

	private int mask(int k) {
  	return k&BYTE_MAX;
  }

  private void flipbit(int k) {
  	int chunk = k/Long.SIZE;
    int bit   = k%Long.SIZE;
    bitset[chunk] ^= 1L<<bit;
  }

	public int put(int k,int v) {
		int safe_k = mask(k);
		int old = containsKey(safe_k)?unsafe_get(k):-1;
	  values[(byte)safe_k] = (byte)mask(v);
	  flipbit(safe_k);
	  n++;
	  return old;
	}

	public int get(int k) {
		int safe_k = mask(k);
		return containsKey(safe_k)?mask(values[safe_k]):-1;
	}

	public int unsafe_get(int k) {
		return mask(values[k]);
	}

	public int remove(int k) {
		int safe_k = mask(k);
    if(containsKey(safe_k)) {
      flipbit(safe_k);
      n--;
      return mask(values[safe_k]);
    }
    return -1;
	}

  public boolean containsKey(int k) {
    int chunk = k/Long.SIZE;
    int bit   = k%Long.SIZE;
    return ((bitset[chunk]>>>bit)&1L)==1L;
  }

	public int size() {
    return n;
	}

	public void clear() {
    for(int i=0;i<BIT_SET_SIZE;bitset[i++]=0);
	}

	public boolean isEmpty() {
		return n==0;
	}
	
	public boolean containsValue(int v) {
		long chunk;
		int bit=0;
    for(int i=0;i<BIT_SET_SIZE;i++) {
    	chunk = bitset[i];
      while(chunk!=0) {
      	int zeroes = Long.numberOfTrailingZeros(chunk);
      	bit += zeroes;
      	chunk >>>= zeroes;
      	if(values[bit&BYTE_MAX]==v) return true;
      }
    }
    return false;
  } 

}