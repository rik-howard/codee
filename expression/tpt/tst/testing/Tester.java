
package testing;

import java.lang.reflect.Method;

public class Tester
{

  protected static final String spc = " ";
  protected static final String dot = ".";
  protected static final String sep = " :: ";

  public static void main (String OPRCSR strings)
  {
    [p:pkgz][c:p.clsz][p.name].[c.name]Tester.main (strings);
    [][][p:pkgz][m:p.modz][p.name].[m.name]Tester.main (strings);
    [][]testivate (Tester.class);
    show ("testing.Tester");
  }

  protected static <T> void testivate (Class <T> tester)
  {
    for (Method method: tester.getMethods ())
      if (method.isAnnotationPresent (Testional.class))
        try {method.invoke (null);}
        catch (Throwable t) {show (null); t.printStackTrace ();}
      else ;
  }

  public static void state (Boolean b, String s, Object expected, Object actual)
  {
    if (b) show (dot);
    else show (expected + sep + actual + spc + s);
  }

  protected static final void show (Object object)
  {
    if (object == null) System.out.println ();
    else if (object.toString ().length () == 1) System.out.print (object.toString ());
    else System.out.println (object.toString ());
  }

}
