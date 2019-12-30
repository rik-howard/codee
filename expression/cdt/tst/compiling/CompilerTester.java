package compiling;

import linking.Linkment;
import testing.Testional;

public class CompilerTester
extends testing.Tester
{

  public static void main (String [] args)
  {
    testivate (compiling.CompilerTester.class);
    show ("compiling.Compiler");
  }

  @Testional public static void testCompilation0 ()
  {
    Linkment compilee = new Linkment ();
    Compilement expected = new Compilement ();
    Compilement actual = Compiler.compilation (compilee);
    state (expected.equals (actual), "testCompilation", expected, actual);
  }

}
