package cleaning;

import testing.Testional;

public class CleanmentTester
extends testing.Tester
{

  private static final Cleanment cleanment = new Cleanment ();

  public static void main (String [] args)
  {
    testivate (cleaning.CleanmentTester.class);
    show ("cleaning.Cleanment");
  }

  @Testional public static void testHashCode ()
  {
    Integer expected = new Cleanment ().hashCode ();
    Integer actual = cleanment.hashCode ();
    state (expected.equals (actual), "testHashCode", expected, actual);
  }

  @Testional public static void testEquals ()
  {
    Boolean expected = false;
    Boolean actual = cleanment.equals (null);
    state (expected.equals (actual), "testEquals0", expected, actual);
    expected = false;
    actual = cleanment.equals (0);
    state (expected.equals (actual), "testEquals1", expected, actual);
    expected = true;
    actual = cleanment.equals (new Cleanment ());
    state (expected.equals (actual), "testEquals2", expected, actual);
  }

  @Testional public static void testToString ()
  {
    String expected = "[" + new String ()
    + "]";
    String actual = cleanment.toString ();
    state (expected.equals (actual), "testToString", expected, actual);
  }

  @Testional public static void testValue ()
  {
    String expected = new String ();
    String actual = cleanment.value ();
    state (expected.equals (actual), "testValue", expected, actual);
  }

}
