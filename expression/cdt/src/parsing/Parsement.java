package parsing;

 

public class Parsement
{

  private String pivot;
  private Parsement left;
  private Parsement right;

  public void setPivot (String pivot) {this.pivot = pivot == null? new String (): pivot;}
  public void setLeft (Parsement left) {this.left = left;}
  public void setRight (Parsement right) {this.right = right;}

  public String pivot () {if (this.pivot == null) this.setPivot (null); return this.pivot;}
  public Parsement left () {return this.left;}
  public Parsement right () {return this.right;}


  @Override public int hashCode ()
  {
    Integer code = 0;
    code += this.pivot ().hashCode ();
    code += this.left () == null? 0: this.left ().hashCode ();
    code += this.right () == null? 0: this.right ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Parsement)
    {
      Boolean equals = true;
      Parsement that = (Parsement) object;
      equals &= this.pivot ().equals (that.pivot ());
      equals &= this.left () == null? that.left () == null: this.left ().equals (that.left ());
      equals &= this.right () == null? that.right () == null: this.right ().equals (that.right ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    StringBuffer buffer = new StringBuffer ("[");
    buffer.append (this.pivot ());
    if (this.left () != null) buffer.append (" | ").append (this.left ());
    if (this.right () != null) buffer.append (" | ").append (this.right ());
    return buffer.append ("]").toString ();
  }

  public String tree ()
  {
    String [] tokens = this
    .toString ()
    .replaceAll ("\\[", " [ ")
    .replaceAll ("\\|", " | ")
    .replaceAll ("\\]", " ] ")
    .trim ()
    .split (" +");
    //
    String indent = "";
    StringBuffer buffer = new StringBuffer ();
    for (String token: tokens)
      if (token.equals ("[")) indent += "  ";
      else if  (token.equals ("|")) ;
      else if  (token.equals ("]")) indent = indent.substring (0, indent.length () - 2);
      else
      {
        buffer.append ("\n");
        buffer.append (indent);
        buffer.append (token);
      }
    return buffer.toString ();
  }

}
