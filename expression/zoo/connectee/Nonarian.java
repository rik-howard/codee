
package connecting.connectee;

import static utility.Lister.*;
import connecting.Connectee;
import connecting.Connector;

public class Nonarian
extends Connectee
{

  public Nonarian () {super ();}
  public Nonarian (String symbol)
  {
    super (new Connector (symbol, 0, "no"), empty (Connectee.class));
  }

  @Override public int hashCode ()
  {
    Integer code = 0;
    code += super.connector ().symbol ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Nonarian)
    {
      Boolean equals = true;
      Nonarian that = (Nonarian) object;
      equals &= super.connector ().symbol ().equals (that.connector ().symbol ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    StringBuffer buffer = new StringBuffer ("[");
    buffer.append (super.connector ().symbol ().toString ());
    return buffer.append ("]").toString ();
  }

}
