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

package no.uib.pviz.pplex.commands;


import no.uib.pviz.pplex.History;
import no.uib.pviz.pplex.LP;
import no.uib.pviz.util.messages.Command;
import no.uib.pviz.util.messages.Response;


public class Pivot implements Command<History<LP>> {

  int entering, leaving;

  public enum Flag {
  	PRIMAL(false), DUAL(true);
    private boolean dual;
    Flag(boolean dual) {
      this.dual=dual;
    }
  }

  private Flag flag;

  public Pivot() {
  	this(Flag.PRIMAL);
  }

  public Pivot(Flag f) {
  	this.flag = flag;
  }

  public Pivot(Flag flag, int entering, int leaving) {
  	this.flag = flag;
  	this.entering = entering;
  	this.leaving = leaving;
  }

  @Override
  public void run(History<LP> h,Response r) {
    if(h.hasCurrent()) {
      LP current = h.getCurrent();
      boolean dual = flag.dual;

        if (entering == -1 && leaving == -1)
          current.pivot(dual);
        else if (dual)
          current.pivot(leaving, entering);
        else current.pivot(entering, leaving);

        h.setCurrent(current);
    }

  }

}