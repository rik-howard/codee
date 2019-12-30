package parsing;

import tokenising.Tokenisement;
import testing.Testional;

public class ParserTester
extends testing.Tester
{

  public static void main (String [] args)
  {
    testivate (parsing.ParserTester.class);
    show ("parsing.Parser");
  }

  @Testional public static void testParsation0 ()
  {
    Tokenisement parsee = new Tokenisement ();
    Parsement expected = new Parsement ();
    Parsement actual = Parser.parsation (parsee);
    state (expected.equals (actual), "testParsation", expected, actual);
  }

}
