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

package no.uib.pviz.util.messages;

import java.util.Map;
import java.util.List;
import java.util.TreeMap;
import java.util.LinkedList;


public class CommandRegistry {
	private List<Integer> commands;
	private Map<Integer,String>  description;
             
  public CommandRegistry() {
    this.commands    = new LinkedList<>();
    this.description = new TreeMap<>();
  }

  public void add(
  	int id,
  	String name,
  	String description) {
  	this.commands.add(id);
  	this.description.put(id,description);
  }

 
}