package tokenising;

import java.util.List;
import java.util.ArrayList;
import static utility.Lister.*;

public class Tokenisement
{

  private Integer index;
  private List <String> tokens;

  public void setIndex (Integer index) {this.index = index == null? new Integer (0): index;}
  public void setTokens (List <String> tokens) {this.tokens = tokens == null? new ArrayList <String> (): tokens;}

  public Integer index () {if (this.index == null) this.setIndex (null); return this.index;}
  public List <String> tokens () {if (this.tokens == null) this.setTokens (null); return this.tokens;}


  @Override public int hashCode ()
  {
    Integer code = 0;
    code += this.index ().hashCode ();
    code += this.tokens ().hashCode ();
    return code;
  }

  @Override public boolean equals (Object object)
  {
    if (object == null) return false;
    else if (object instanceof Tokenisement)
    {
      Boolean equals = true;
      Tokenisement that = (Tokenisement) object;
      equals &= this.index ().equals (that.index ());
      equals &= this.tokens ().equals (that.tokens ());
      return equals;
    }
    else return false;
  }

  @Override public String toString ()
  {
    StringBuffer buffer = new StringBuffer ("[");
    buffer.append (this.index ());
    buffer.append (" | ").append (this.tokens ());
    return buffer.append ("]").toString ();
  }

  public Boolean hasMoreTokens ()
  {
    return this.index () < this.tokens ().size ();
  }

  public Boolean tokenIs (String token)
  {
    return this.hasMoreTokens ()? first (this.tokens ()).equals (token): token == null;
  }

  public Boolean tokenIsOne (List <String> tokens)
  {
    if (tokens == null) return false;
    else if (this.hasMoreTokens ())
      return tokens.contains (first (this.tokens ()));
    else return false;
  }

  public String token ()
  {
    if (this.hasMoreTokens ())
    {
      String token = first (this.tokens ());
      this.setTokens (rest (this.tokens ()));
      return token;
    }
    else return null;
  }

}
