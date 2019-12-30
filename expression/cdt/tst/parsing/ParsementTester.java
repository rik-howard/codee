package parsing;

import testing.Testional;

public class ParsementTester
extends testing.Tester
{

  private static final Parsement parsement = new Parsement ();

  public static void main (String [] args)
  {
    testivate (parsing.ParsementTester.class);
    show ("parsing.Parsement");
  }

  @Testional public static void testHashCode ()
  {
    Integer expected = new Parsement ().hashCode ();
    Integer actual = parsement.hashCode ();
    state (expected.equals (actual), "testHashCode", expected, actual);
  }

  @Testional public static void testEquals ()
  {
    Boolean expected = false;
    Boolean actual = parsement.equals (null);
    state (expected.equals (actual), "testEquals0", expected, actual);
    expected = false;
    actual = parsement.equals (0);
    state (expected.equals (actual), "testEquals1", expected, actual);
    expected = true;
    actual = parsement.equals (new Parsement ());
    state (expected.equals (actual), "testEquals2", expected, actual);
  }

  @Testional public static void testToString ()
  {
    String expected = "[" + new String ()
    + "]";
    String actual = parsement.toString ();
    state (expected.equals (actual), "testToString", expected, actual);
  }

  @Testional public static void testPivot ()
  {
    String expected = new String ();
    String actual = parsement.pivot ();
    state (expected.equals (actual), "testPivot", expected, actual);
  }

  @Testional public static void testLeft ()
  {
    Parsement expected = null;
    Parsement actual = parsement.left ();
    state (expected == actual, "testLeft", expected, actual);
  }

  @Testional public static void testRight ()
  {
    Parsement expected = null;
    Parsement actual = parsement.right ();
    state (expected == actual, "testRight", expected, actual);
  }

}
