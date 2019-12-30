
package main;

import static utility.Printer.*;
import static utility.Lister.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Properties;

public class Connectors
{

  public static final List <String> binaryInfixMajor = empty (String.class);
  public static final List <String> binaryPrefix = empty (String.class);
  public static final List <String> unaryPrefix = empty (String.class);
  public static final List <String> unaryPostfix = empty (String.class);
  public static final List <String> unaryOutfixOpeners = empty (String.class);
  public static final List <String> unaryOutfixClosers = empty (String.class);
  public static final List <String> binaryInfixMinor = empty (String.class);
  public static final List <String> punctors = empty (String.class);
  public static final List <String> literals = empty (String.class);

  static
  {
    Properties properties = new Properties ();
    InputStream stream = ClassLoader.getSystemClassLoader ().getResourceAsStream ("main/connector.properties");
    if (stream == null) throw new Error ("there are no connector properties");
    else try 
    {
      properties.load (stream);
      List <String> keys = list (properties.stringPropertyNames ());
      Collections.sort (keys);
      for (String key: keys)
        if (key.startsWith ("connector.binary.infix.major")) binaryInfixMajor.add (properties.getProperty (key));
        else if (key.startsWith ("connector.binary.prefix")) binaryPrefix.add (properties.getProperty (key));
        else if (key.startsWith ("connector.unary.prefix")) unaryPrefix.add (properties.getProperty (key));
        else if (key.startsWith ("connector.unary.postfix")) unaryPostfix.add (properties.getProperty (key));
        else if (key.startsWith ("connector.unary.outfix.opener")) unaryOutfixOpeners.add (properties.getProperty (key));
        else if (key.startsWith ("connector.unary.outfix.closer")) unaryOutfixClosers.add (properties.getProperty (key));
        else if (key.startsWith ("connector.binary.infix.minor")) binaryInfixMinor.add (properties.getProperty (key));
        else nb (0, "the key is not known: " + key);
    }
    catch (IOException e) {e.printStackTrace ();}
    punctors.addAll (binaryInfixMajor);
    punctors.addAll (binaryPrefix);
    punctors.addAll (unaryPrefix);
    punctors.addAll (unaryPostfix);
    punctors.addAll (unaryOutfixOpeners);
    punctors.addAll (unaryOutfixClosers);
    punctors.addAll (binaryInfixMinor);
  }

  public static final String literalKey (String literalValue)
  {
    String key = "L" + literals.size ();
    literals.add (literalValue);
    return key;
  }

  public static final String literalValue (String literalKey)
  {
    if (literalKey == null) return emError ("null literal key");
    else if (idsLiteralKey (literalKey))
      return literals.get (Integer.parseInt (literalKey.substring (1)));
    else return emError ("the key is not of a literal: " + literalKey);
  }

  public static final String nextBIKey (String biKey)
  {
    if (biKey == null)
      if (binaryInfixMajor.size () > 0) return "P0";
      else return null;
    else if (idsPunctorKey (biKey))
      if (index (biKey) + 1 < binaryInfixMajor.size ()) return "P" + (index (biKey) + 1);
      else return null;
    else return emError ("not a punctor key: " + biKey);
  }

  public static final String punctorKey (String punctorValue)
  {
    if (punctorValue == null) return emError ("null punctor value");
    else if (punctors.contains (punctorValue))
      return "P" + punctors.indexOf (punctorValue);
    else return emError ("the value is not of a punctor: " + punctorValue);
  }

  public static final String closer (String opener)
  {
    if (idsPunctorKey (opener))
    {
      Integer punctorIndex = index (opener);
      String openerValue = punctors.get (punctorIndex);
      Integer openerIndex = unaryOutfixOpeners.indexOf (openerValue);
      String closerValue = unaryOutfixClosers.get (openerIndex);
      return "P" + punctors.indexOf (closerValue);
    }
    else return emError ("not a punctor key: " + opener);
  }

  public static final String punctorValue (String punctorKey)
  {
    if (idsPunctorKey (punctorKey))
    {
      Integer index = index (punctorKey);
      if (index < punctors.size ()) return punctors.get (index);
      else return emError ("there is a too-large index of the punctor key: " + punctorKey);
    }
    else return null;
  }

  public static final List <String> punctorKeys (List <String> punctorValues)
  {
    List <String> punctorKeys = new ArrayList <String> ();
    if (punctorValues == null) ;
    else for (String value: punctorValues) punctorKeys.add ("P" + punctors.indexOf (value));
    return punctorKeys;
  }

  public static final String nextMIKey (String miKey)
  {
    if (miKey == null)
      if (binaryInfixMinor.size () > 0) return punctorKey (binaryInfixMinor.get (0));
      else return null;
    else if (binaryInfixMinor.contains (punctorValue (miKey)))
      if (binaryInfixMinor.indexOf (punctorValue (miKey)) + 1 < binaryInfixMinor.size ())
          return punctorKey (binaryInfixMinor.get (binaryInfixMinor.indexOf (punctorValue (miKey)) + 1));
      else return null;
    else return emError ("not a minor key: " + miKey);

  }

  public static List <String> punctorsByLength ()
  {
    List <String> ps = new ArrayList <String> ();
    List <String> pxs = new ArrayList <String> ();
    for (String string: punctors) pxs.add (string);
    while (pxs.size () > 0)
    {
      String longest = "";
      for (String s: pxs) if (s.length () > longest.length ()) longest = s;
      pxs.remove (longest);
      ps.add (longest);
    }
    return ps;
  }

  private static final Boolean idsLiteralKey (String string)
  {
    return string.matches ("L[0-9]+");
  }

  private static final Boolean idsPunctorKey (String string)
  {
    return string.matches ("P[0-9]+");
  }

  private static final Integer index (String string)
  {
    assert idsLiteralKey (string) || idsPunctorKey (string);
    return Integer.parseInt (string.substring (1));
  }

}
