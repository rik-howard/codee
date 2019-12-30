package cleaning;

// @cleanment-imports

public class Cleanment
{

  private String value;

  public void setValue (String value) {this.value = value == null? new String (): value;}

  public String value () {if (this.value == null) this.setValue (null); return this.value;}


  @Override public int hashCode ()
  {
    Integer code = 0;
    code += this.value ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Cleanment)
    {
      Boolean equals = true;
      Cleanment that = (Cleanment) object;
      equals &= this.value ().equals (that.value ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    StringBuffer buffer = new StringBuffer ("[");
    buffer.append (this.value ());
    return buffer.append ("]").toString ();
  }

  // @cleanment-members

}
