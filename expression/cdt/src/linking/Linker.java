package linking;

import parsing.Parsement;
// @linker-imports

public class Linker
{

  public static final Linkment linking (Parsement linkee)
  {
    return new Linkment ();  // @0-linking
  }

  // @linker-members

}
