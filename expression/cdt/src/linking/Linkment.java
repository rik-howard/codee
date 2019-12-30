package linking;

// @linkment-imports

public class Linkment
{

  private String pivot;
  private Linkment left;
  private Linkment right;

  public void setPivot (String pivot) {this.pivot = pivot == null? new String (): pivot;}
  public void setLeft (Linkment left) {this.left = left;}
  public void setRight (Linkment right) {this.right = right;}

  public String pivot () {if (this.pivot == null) this.setPivot (null); return this.pivot;}
  public Linkment left () {return this.left;}
  public Linkment right () {return this.right;}


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
    else if (object instanceof Linkment)
    {
      Boolean equals = true;
      Linkment that = (Linkment) object;
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

  // @linkment-members

}
