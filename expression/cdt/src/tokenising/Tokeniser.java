package tokenising;

import cleaning.Cleanment;
import static utility.Lister.*;
import static main.Factory.*;
import static main.Connectors.*;

public class Tokeniser
{

  public static final Tokenisement tokenisation (Cleanment tokenisee)
  {
    String string = tokenisee.value ();
    for (String punctor: punctorsByLength ())
      while (idsPunctivity (string, punctor))
        string = depunctivated (string, punctor, "P" + punctors.indexOf (punctor));
    return tokenisement (list (string.trim ().split (" +")));
  }

  private static final String space = " ";

  private static final Boolean idsPunctivity (String string, String punctor)
  {
    return string.indexOf (punctor) > -1;
  }

  private static String depunctivated (String string, String value, String key)
  {
    return string.replace (value, space + key + space);
  }

}
