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
import no.uib.pviz.pplex.parser.LpFileFormatLexer;
import no.uib.pviz.pplex.parser.LpFileFormatParser;
import no.uib.pviz.util.messages.Command;
import no.uib.pviz.util.messages.Response;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.TokenStream;

import java.io.IOException;


public class Read implements Command<History<LP>> {

  String file;

	public Read(String file) {
		this.file = file;
	}

  @Override
  public void run(History<LP> h,Response r) {

    CharStream stream;
    try {
      stream = new ANTLRFileStream(file);
      LpFileFormatLexer lexer = new LpFileFormatLexer(stream);
      TokenStream tokenStream = new CommonTokenStream(lexer);
      LpFileFormatParser parser = new LpFileFormatParser(tokenStream);
      h.setCurrent((parser.lpfromfile()));
    } catch (IOException | RecognitionException ignored) {

    }

  }
}