
package connecting.connector;

import connecting.Connector;

public class Ternarian
extends Connector
{

  public Ternarian () {super ();}
  public Ternarian (String symbol)
  {
    super (symbol, 3, "in");
  }

}
