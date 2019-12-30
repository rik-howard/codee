package main;

import static utility.Printer.*;
import static main.Connectors.*;
import cleaning.Cleaner;
import cleaning.Cleanment;
import tokenising.Tokeniser;
import tokenising.Tokenisement;
import parsing.Parser;
import parsing.Parsement;
import linking.Linker;
import linking.Linkment;
import compiling.Compiler;
import compiling.Compilement;

public class Main
{

  public static final void main (String [] args)
  {
    say (null);
    say ("    punctors: " + punctors);
    String raw = raw (args);
    say (null);
    say ("         raw: " + raw);
    Cleanment cleanment = Cleaner.cleaning (raw);
    say (null);
    say ("   cleanment: " + cleanment);
    say ("    literals: " + literals);
    Tokenisement tokenisement = Tokeniser.tokenisation (cleanment);
    say (null);
    say ("tokenisement: " + tokenisement);
    Parsement parsement = Parser.parsation (tokenisement);
    say (null);
    say ("   parsement: " + parsement);
    say ("        tree: " + parsement.tree ());
    Linkment linkment = Linker.linking (parsement);
    say (null);
    say ("    linkment: " + linkment);
    Compilement compilement = Compiler.compilation (linkment);
    say (null);
    say (" compilement: " + compilement);
    say (null);
  }

  private static final String raw (String [] strings)
  {
    StringBuffer buffer = new StringBuffer ();
    String sep = " ";
    if (strings == null) return null;
    else for (String string: strings)
      if (buffer.toString ().isEmpty ()) buffer.append (string);
      else buffer.append (sep).append (string);
    return buffer.toString ();
  }

}
