package main;

import testing.Testional;

public class MainTester
extends testing.Tester
{

  public static void main (String [] args)
  {
    testivate (main.MainTester.class);
    show ("main.Main");
  }

  @Testional public static void testMain0 ()
  {
    String [] args = new String [0];
    Main.main (args);
  }

}
