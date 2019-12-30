package tokenising;

import cleaning.Cleanment;
import testing.Testional;

public class TokeniserTester
extends testing.Tester
{

  public static void main (String [] args)
  {
    testivate (tokenising.TokeniserTester.class);
    show ("tokenising.Tokeniser");
  }

  @Testional public static void testTokenisation0 ()
  {
    Cleanment tokenisee = new Cleanment ();
    Tokenisement expected = new Tokenisement ();
    Tokenisement actual = Tokeniser.tokenisation (tokenisee);
    state (expected.equals (actual), "testTokenisation", expected, actual);
  }

}
