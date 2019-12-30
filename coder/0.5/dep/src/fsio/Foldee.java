
package fsio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Foldee
implements Folden
{

  private String name;
  private List <? extends Line> lines;

  public void setName (String name) {this.name = name == null? new String (): name;}
  public void setLines (List <? extends Line> lines) {this.lines = lines == null? new ArrayList <Line> (): lines;}

  public String name () {if (this.name == null) this.setName (null); return this.name;}
  public List <? extends Line> lines () {if (this.lines == null) this.setLines (null); return this.lines;}

  @Override public int hashCode ()
  {
    Integer code = 0;
    code += this.name ().hashCode ();
    code += this.lines ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Foldee)
    {
      Boolean equals = true;
      Foldee that = (Foldee) object;
      equals &= this.name ().equals (that.name ());
      equals &= this.lines ().equals (that.lines ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    StringBuffer buffer = new StringBuffer ();
    buffer.append ("[").append (this.name ().toString ());
    buffer.append (" | ").append (this.lines ().toString ());
    buffer.append ("]");
    return buffer.toString ();
  }

  public void store ()
  throws IOException
  {
    this.store (new File (this.name ()));
  }

  void store (File file)
  throws IOException
  {
    if (file.exists ()) assert true;
    else if (file.getParentFile ().exists ()) file.createNewFile ();
    else
    {
      file.getParentFile ().mkdirs ();
      file.createNewFile ();
    }
    if (file.length () == 0)
    {
      FileWriter writer = new FileWriter (file);
      writer.write (this.value (), 0, this.value ().length ());
      writer.flush ();
      writer.close ();
    }
  }

  private String value ()
  {
    StringBuffer buffer = new StringBuffer ();
    for (Line line: this.lines ())
      buffer.append (line.value ()).append (eol);
    return buffer.toString ();
  }

}
