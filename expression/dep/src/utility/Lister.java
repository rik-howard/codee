
package utility;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Lister
{

  public static <T> T first (List <T> tz)
  {
    assert tz.size () > 0;
    return tz.get (0);
  }

  public static <T> List <T> rest (List <T> tz)
  {
    assert tz.size () > 0;
    List <T> rest = new ArrayList <T> ();
    for (Integer i = 1; i < tz.size (); i++)
      rest.add (tz.get (i));
    return rest;
  }

  public static <T> List <T> union (T t0, T t1)
  {
    List <T> union = new ArrayList <T> ();
    assert t0 != null;
    union.add (t0);
    if (t1 != null) union.add (t1);
    return union;
  }

  public static <T> List <T> union (T t, List <T> tz)
  {
    List <T> union = new ArrayList <T> ();
    assert t != null;
    union.add (t);
    if (tz != null) union.addAll (tz);
    return union;
  }

  public static <T> List <T> union (List <T> t0z, List <T> t1z)
  {
    List <T> union = new ArrayList <T> ();
    assert t0z != null && t1z != null;
    union.addAll (t0z);
    union.addAll (t1z);
    return union;
  }

  public static <T> List <T> empty (Class <T> t)
  {
    return new ArrayList <T> ();
  }

  public static <T> List <T> list (T ... tz)
  {
    List <T> list = new ArrayList <T> ();
    for (T t: tz) list.add (t);
    return list;
  }

  public static <T> List <T> list (Collection <T> tz)
  {
    List <T> list = new ArrayList <T> ();
    for (T t: tz) list.add (t);
    return list;
  }

  public static <T> List <T> list (Set <T> tz)
  {
    List <T> list = new ArrayList <T> ();
    for (T t: tz) list.add (t);
    return list;
  }

}
