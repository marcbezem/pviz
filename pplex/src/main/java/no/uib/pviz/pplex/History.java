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

package no.uib.pviz.pplex;

import java.util.LinkedList;

public class History<T> {
  
  private static final int MAX = 10;
  private int history_max;
	private int size;
	private LinkedList<T> undo;
	private LinkedList<T> redo;
	private T current;

	public History() {
	  this(MAX);
	}

	public History(int n) {
	  history_max = n;
	  size = 0;
      current = null;
      undo = new LinkedList<>();
      redo = new LinkedList<>();
	}

  
  public boolean hasCurrent() {
  	return current != null;
  }

  public boolean undo() {
    boolean performed = !undo.isEmpty();
    if(performed) {
    	redo.push(current);
    	current = undo.pop();
    }
    return performed;
  }

  public boolean redo() {
    boolean performed = !redo.isEmpty();
    if(performed) {
    	undo.push(current);
    	current = redo.pop();
    }
    return performed;
  }

  public void setCurrent(final T newCurrent) {
    undo.push(current);
    current = newCurrent;
    if(history_max < size) {
    	undo.removeLast();	
    } else {
    	size++;
    }

  }

  public T getCurrent() {
    return current;
  }
}