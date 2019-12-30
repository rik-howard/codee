package cleaning;

import static main.Factory.*;
import static main.Connectors.*;

public class Cleaner
{

  public static final Cleanment cleaning (String cleanee)
  {
    if (idsComment (cleanee)) cleanee = decommed (cleanee);
    while (idsQuotation (cleanee)) cleanee = dequoted (cleanee);
    return cleanment (cleanee);
  }

  private static final String commentSymbol = "¢";
  private static final String quoteSymbol = "\"";

  private static final Boolean idsComment (String string)
  {
    return string.indexOf (commentSymbol) > -1;
  }

  private static final Boolean idsQuotation (String string)
  {
    Integer here = string.indexOf (quoteSymbol);
    Integer there = string.indexOf (quoteSymbol, here + 1);
    return here < there;
  }

  public static final String decommed (String string)
  {
    assert idsComment (string);
    Integer index = string.indexOf (commentSymbol);
    return string.substring (0, index).trim ();
  }

  public static final String dequoted (String string)
  {
    assert idsQuotation (string);
    Integer here = string.indexOf (quoteSymbol);
    Integer there = string.indexOf (quoteSymbol, here + 1);
    return string.substring (0, here)
    + literalKey (string.substring (here, there + 1))
    + string.substring (there + 1);
  }

}
