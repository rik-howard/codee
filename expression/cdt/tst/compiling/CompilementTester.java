package compiling;

import java.util.List;
import java.util.ArrayList;
import testing.Testional;

public class CompilementTester
extends testing.Tester
{

  private static final Compilement compilement = new Compilement ();

  public static void main (String [] args)
  {
    testivate (compiling.CompilementTester.class);
    show ("compiling.Compilement");
  }

  @Testional public static void testHashCode ()
  {
    Integer expected = new Compilement ().hashCode ();
    Integer actual = compilement.hashCode ();
    state (expected.equals (actual), "testHashCode", expected, actual);
  }

  @Testional public static void testEquals ()
  {
    Boolean expected = false;
    Boolean actual = compilement.equals (null);
    state (expected.equals (actual), "testEquals0", expected, actual);
    expected = false;
    actual = compilement.equals (0);
    state (expected.equals (actual), "testEquals1", expected, actual);
    expected = true;
    actual = compilement.equals (new Compilement ());
    state (expected.equals (actual), "testEquals2", expected, actual);
  }

  @Testional public static void testToString ()
  {
    String expected = "[" + new ArrayList <String> ()
    + "]";
    String actual = compilement.toString ();
    state (expected.equals (actual), "testToString", expected, actual);
  }

  @Testional public static void testValues ()
  {
    List <String> expected = new ArrayList <String> ();
    List <String> actual = compilement.values ();
    state (expected.equals (actual), "testValues", expected, actual);
  }

}
