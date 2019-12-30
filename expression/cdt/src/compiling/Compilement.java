package compiling;

import java.util.List;
import java.util.ArrayList;
// @compilement-imports

public class Compilement
{

  private List <String> values;

  public void setValues (List <String> values) {this.values = values == null? new ArrayList <String> (): values;}

  public List <String> values () {if (this.values == null) this.setValues (null); return this.values;}


  @Override public int hashCode ()
  {
    Integer code = 0;
    code += this.values ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Compilement)
    {
      Boolean equals = true;
      Compilement that = (Compilement) object;
      equals &= this.values ().equals (that.values ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    StringBuffer buffer = new StringBuffer ("[");
    buffer.append (this.values ());
    return buffer.append ("]").toString ();
  }

  // @compilement-members

}
