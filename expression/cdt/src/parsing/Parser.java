package parsing;

import tokenising.Tokenisement;
import static utility.Printer.*;
import static main.Factory.*;
import static main.Connectors.*;

public class Parser
{

  public static final Parsement parsation (Tokenisement parsee)
  {
    if (parsee.hasMoreTokens ())
      if (binaryInfixMajor.size () > 0) return binaryInfix (parsee, "P0");
      else return binaryPrefix (parsee);
    else return new Parsement ();
  }

  private static final Parsement binaryInfix (Tokenisement parsee, String biKey)
  {
    String next = nextBIKey (biKey);
    Parsement parsement;
    if (next == null) parsement = binaryPrefix (parsee);
    else parsement = binaryInfix (parsee, next);
    if (parsee.tokenIs (biKey))
    {
      String punctorKey = parsee.token ();  // consumes token
      return parsement ("I" + punctorKey, parsement, binaryInfix (parsee, punctorKey));
    }
    else return parsement;
  }

  private static final Parsement binaryPrefix (Tokenisement parsee)
  {
    if (parsee.tokenIsOne (punctorKeys (binaryPrefix)))
    {
      String punctorKey = parsee.token ();  // consumes token
      Parsement left = binaryPrefix (parsee);
      return parsement ("E" + punctorKey, left, binaryPrefix (parsee));
    }
    else return unaryPrefix (parsee);
  }

  private static final Parsement unaryPrefix (Tokenisement parsee)
  {
    if (parsee.tokenIsOne (punctorKeys (unaryPrefix)))
    {
      String punctorKey = parsee.token ();  // consumes token
      return parsement ("E" + punctorKey, binaryPrefix (parsee), null);
    }
    else return unaryPostfix (parsee);
  }

  private static final Parsement unaryPostfix (Tokenisement parsee)
  {
    Parsement parsement = unaryOutfix (parsee);
    if (parsee.tokenIsOne (punctorKeys (unaryPostfix))) return _unaryPostfix (parsee, parsement);
    else return parsement;
  }

  private static final Parsement _unaryPostfix (Tokenisement parsee, Parsement parsement)
  {
    String punctorKey = parsee.token ();  // consumes token
    parsement = parsement ("O" + punctorKey, parsement, null);
    if (parsee.tokenIsOne (punctorKeys (unaryPostfix))) return _unaryPostfix (parsee, parsement);
    else return parsement;
  }

  private static final Parsement unaryOutfix (Tokenisement parsee)
  {
    if (parsee.tokenIsOne (punctorKeys (unaryOutfixOpeners)))
    {
      String opener = parsee.token ();  // consumes opener token
      if (parsee.tokenIs (closer (opener)))
      {
        String closer = parsee.token ();  // consumes closer token
        return parsement ("U" + opener + closer, null, null);
      }
      else
      {
        Parsement parsement = parsation (parsee);
        if (parsee.tokenIs (closer (opener)))
          return parsement ("U" + opener + parsee.token (), parsement, null);  // consumes closer token
        else return emError ("closer not found: " + parsee);
      }
    }
    else return infixMinor (parsee, nextMIKey (null));
  }

  private static final Parsement infixMinor (Tokenisement parsee, String miKey)
  {
    String next = nextMIKey (miKey);
    Parsement parsement;
    if (next == null) parsement = nonary (parsee);
    else parsement = infixMinor (parsee, next);
    if (parsee.tokenIs (miKey))
    {
      String punctorKey = parsee.token ();  // consumes token
      return parsement ("A" + punctorKey, parsement, infixMinor (parsee, punctorKey));
    }
    else return parsement;
  }

  private static final Parsement nonary (Tokenisement parsee)
  {
    Parsement parsement = parsement (parsee.token (), null, null);
    if (parsee.tokenIsOne (punctorKeys (unaryOutfixOpeners)))
      parsement.setLeft (unaryOutfix (parsee));
    return parsement;
  }

}
