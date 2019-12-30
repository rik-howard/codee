package linking;

import parsing.Parsement;
import testing.Testional;

public class LinkerTester
extends testing.Tester
{

  public static void main (String [] args)
  {
    testivate (linking.LinkerTester.class);
    show ("linking.Linker");
  }

  @Testional public static void testLinking0 ()
  {
    Parsement linkee = new Parsement ();
    Linkment expected = new Linkment ();
    Linkment actual = Linker.linking (linkee);
    state (expected.equals (actual), "testLinking", expected, actual);
  }

}
