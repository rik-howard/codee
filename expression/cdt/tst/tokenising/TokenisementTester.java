package tokenising;

import java.util.List;
import java.util.ArrayList;
import testing.Testional;

public class TokenisementTester
extends testing.Tester
{

  private static final Tokenisement tokenisement = new Tokenisement ();

  public static void main (String [] args)
  {
    testivate (tokenising.TokenisementTester.class);
    show ("tokenising.Tokenisement");
  }

  @Testional public static void testHashCode ()
  {
    Integer expected = new Tokenisement ().hashCode ();
    Integer actual = tokenisement.hashCode ();
    state (expected.equals (actual), "testHashCode", expected, actual);
  }

  @Testional public static void testEquals ()
  {
    Boolean expected = false;
    Boolean actual = tokenisement.equals (null);
    state (expected.equals (actual), "testEquals0", expected, actual);
    expected = false;
    actual = tokenisement.equals (0);
    state (expected.equals (actual), "testEquals1", expected, actual);
    expected = true;
    actual = tokenisement.equals (new Tokenisement ());
    state (expected.equals (actual), "testEquals2", expected, actual);
  }

  @Testional public static void testToString ()
  {
    String expected = "[" + new Integer (0)
    + " | " + new ArrayList <String> ()
    + "]";
    String actual = tokenisement.toString ();
    state (expected.equals (actual), "testToString", expected, actual);
  }

  @Testional public static void testIndex ()
  {
    Integer expected = new Integer (0);
    Integer actual = tokenisement.index ();
    state (expected.equals (actual), "testIndex", expected, actual);
  }

  @Testional public static void testTokens ()
  {
    List <String> expected = new ArrayList <String> ();
    List <String> actual = tokenisement.tokens ();
    state (expected.equals (actual), "testTokens", expected, actual);
  }

}
