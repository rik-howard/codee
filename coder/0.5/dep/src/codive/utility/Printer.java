
package codive.utility;

public class Printer
{

  private static final Integer dbg = 2;

  //private static final void toStd (Object object)
  //{
   // if (object == null) System.out.println ();
    //else if (object.toString ().length () == 1) System.out.print (object.toString ());
    //else System.out.println (object.toString ());
  //}

  private static final void toErr (Object object)
  {
    if (object == null) System.err.println ();
    else if (object.toString ().length () == 1) System.err.print (object.toString ());
    else System.err.println (object.toString ());
  }

  public static final void nb (Integer integer, Object object)
  {
    if (dbg > integer) toErr ("coder: " + object.toString ());
  }

  public static final void dbg (Object object)
  {
    toErr (object);
  }

  public static final void em (Object object)
  {
    // ex machina
    //throw new Exception (object.toString ());
    //toStd (object);
    //System.exit (0);
  }

  public static final Object nbNull (Integer integer, Object object)
  {
    nb (integer, object);
    return null;
  }

}
