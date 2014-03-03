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

public class Show implements Command<History<LP>> {

  static final String name="show";

  public enum SubCommand implements Command<History<LP>> {

    PRIMAL {
      @Override
      public void run(History<LP> h, Response r) {

      }

    },
    DUAL {
      @Override
      public void run(History<LP> h, Response r) {

      }

    },
    FEASABILITY {
      @Override
      public void run(History<LP> h, Response r) {

      }
    },
    OPTIMALITY {
      @Override
      public void run(History<LP> h, Response r) {

      }
    },
    SOLUTION {
      @Override
      public void run(History<LP> h, Response r) {

      }
    }


	}

	SubCommand subcommand;
	int precision;

	public Show() {
		this(SubCommand.PRIMAL,2);
	}

	public Show(SubCommand subcommand, int precision) {
	  this.subcommand = subcommand;
    this.precision = precision;
	}

  @Override
  public void run(History<LP> h, Response r) {
    if(h.hasCurrent()) {
      subcommand.run(h,r);
    }
  }
}