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

import no.uib.pviz.util.messages.Command;

import no.uib.pviz.core.ManagedArray;
import no.uib.pviz.core.ArrayManager;
import no.uib.pviz.core.ByteSetArrayManager;



public class CommandFactory extends ManagedArray {

  Command[] commands;
  ArrayManager commands_m;

  public CommandFactory(int n) {
    commands   = new Command[n];
    commands_m = new ByteSetArrayManager(this); 
  }
  
  public Command create(int id) {
    return commands[commands_m.get(id)];
  }

  public boolean remove(int id) {
    return commands_m.remove(id);  
  }

  public void insert(int id,Command cmd) {
    commands[commands_m.insert(id)] = cmd; 
  }

  void move(int to, int from) {
    commands[to] = commands[from];
  }

  void swap(int i, int j) {
    Command temp = commands[i];
    commands[i]  = commands[j];
    commands[j]  = temp;
  }

}