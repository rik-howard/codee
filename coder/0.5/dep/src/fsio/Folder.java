package fsio;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Folder
implements Folden
{

  private String name;
  private List <? extends Folder> folders;
  private List <? extends Foldee> foldees;

  public void setName (String name) {this.name = name == null? new String (): name;}
  public void setFolders (List <? extends Folder> folders) {this.folders = folders == null? new ArrayList <Folder> (): folders;}
  public void setFoldees (List <? extends Foldee> foldees) {this.foldees = foldees == null? new ArrayList <Foldee> (): foldees;}

  public String name () {if (this.name == null) this.setName (null); return this.name;}
  public List <? extends Folder> folders () {if (this.folders == null) this.setFolders (null); return this.folders;}
  public List <? extends Foldee> foldees () {if (this.foldees == null) this.setFoldees (null); return this.foldees;}

  @Override public int hashCode ()
  {
    Integer code = 0;
    code += this.name ().hashCode ();
    code += this.folders ().hashCode ();
    code += this.foldees ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Folder)
    {
      Boolean equals = true;
      Folder that = (Folder) object;
      equals &= this.name ().equals (that.name ());
      equals &= this.folders ().equals (that.folders ());
      equals &= this.foldees ().equals (that.foldees ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    String o = "<";
    String c = ">";
    String s = " | ";
    StringBuffer buffer = new StringBuffer (o);
    buffer.append (this.name ().toString ());
    buffer.append (s).append (this.folders ().toString ());
    buffer.append (s).append (this.foldees ().toString ());
    return buffer.append (c).toString ();
  }

  public void store ()
  throws IOException
  {
    this.store (null);
  }

  public List <Folden> leaves ()
  {
    throw new UnsupportedOperationException ();
  }

  // @package

  private void store (File parent)
  throws IOException
  {
    File file = this.file (parent);
    if (file.exists ()) assert true;
    else file.mkdirs ();
    for (Folder folder: this.folders ()) folder.store (file);
    for (Foldee foldee: this.foldees ()) foldee.store (new File (file.getPath () + File.separator + foldee.name ()));
  }

  private File file (File parent)
  {
    if (parent == null) return new File (this.name ());
    else return new File (parent.getPath () + File.separator + this.name ());
  }

}
