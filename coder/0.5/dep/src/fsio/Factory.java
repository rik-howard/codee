package fsio;

import fsio.Line;
import fsio.Foldee;
import fsio.Folder;
import java.util.List;

public class Factory
{

  public static final Line line (String value)
  {
    Line line = new Line ();
    line.setValue (value);
    return line;
  }

  public static final Foldee fSFoldee (String name, List <? extends Line> lines)
  {
    Foldee foldee = new Foldee ();
    foldee.setName (name);
    foldee.setLines (lines);
    return foldee;
  }

  public static final Folder folder (String name, List <? extends Folder> folders, List <? extends Foldee> foldees)
  {
    Folder folder = new Folder ();
    folder.setName (name);
    folder.setFolders (folders);
    folder.setFoldees (foldees);
    return folder;
  }

}
