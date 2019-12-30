package linking;

import testing.Testional;

public class LinkmentTester
extends testing.Tester
{

  private static final Linkment linkment = new Linkment ();

  public static void main (String [] args)
  {
    testivate (linking.LinkmentTester.class);
    show ("linking.Linkment");
  }

  @Testional public static void testHashCode ()
  {
    Integer expected = new Linkment ().hashCode ();
    Integer actual = linkment.hashCode ();
    state (expected.equals (actual), "testHashCode", expected, actual);
  }

  @Testional public static void testEquals ()
  {
    Boolean expected = false;
    Boolean actual = linkment.equals (null);
    state (expected.equals (actual), "testEquals0", expected, actual);
    expected = false;
    actual = linkment.equals (0);
    state (expected.equals (actual), "testEquals1", expected, actual);
    expected = true;
    actual = linkment.equals (new Linkment ());
    state (expected.equals (actual), "testEquals2", expected, actual);
  }

  @Testional public static void testToString ()
  {
    String expected = "[" + new String ()
    + "]";
    String actual = linkment.toString ();
    state (expected.equals (actual), "testToString", expected, actual);
  }

  @Testional public static void testPivot ()
  {
    String expected = new String ();
    String actual = linkment.pivot ();
    state (expected.equals (actual), "testPivot", expected, actual);
  }

  @Testional public static void testLeft ()
  {
    Linkment expected = null;
    Linkment actual = linkment.left ();
    state (expected == actual, "testLeft", expected, actual);
  }

  @Testional public static void testRight ()
  {
    Linkment expected = null;
    Linkment actual = linkment.right ();
    state (expected == actual, "testRight", expected, actual);
  }

}
