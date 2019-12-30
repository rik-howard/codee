package cleaning;

import testing.Testional;

public class CleanerTester
extends testing.Tester
{

  public static void main (String [] args)
  {
    testivate (cleaning.CleanerTester.class);
    show ("cleaning.Cleaner");
  }

  @Testional public static void testCleaning0 ()
  {
    String cleanee = new String ();
    Cleanment expected = new Cleanment ();
    Cleanment actual = Cleaner.cleaning (cleanee);
    state (expected.equals (actual), "testCleaning", expected, actual);
  }

}
