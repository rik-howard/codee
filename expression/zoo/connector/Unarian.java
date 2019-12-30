
package connecting.connector;

import connecting.Connector;

public class Unarian
extends Connector
{

  public Unarian () {super ();}
  public Unarian (String symbol, String fixment)
  {
    super (symbol, 1, fixment);
  }

}
