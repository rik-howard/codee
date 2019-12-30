
package connecting.connector;

import connecting.Connector;

public class Binarian
extends Connector
{

  public Binarian () {super ();}
  public Binarian (String symbol, String fixment)
  {
    super (symbol, 2, fixment);
  }

}
