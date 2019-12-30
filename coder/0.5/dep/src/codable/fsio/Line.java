
package codable.fsio;

import java.util.ArrayList;
import java.util.List;

public class Line
extends fsio.Line
{

  private static final String comment = "¢";
  private static final String regexSector = "^> [a-z]+$";
  private static final String neck = ":";
  private static final String comma = ",";
  private static final String space = " ";
  private static final String opener = "(";
  private static final String closer = "(";
  public static final String procedureIntroducer = "intro";
  public static final String procedureEnding = "end";
  public static final String regexSymbolName = "([a-zA-Z0-9]+|[0-9]+)";
  public static final String regexSymbolValue = "^[^ ]*$";
  public static final String regexRelationId = "^[A-Z][a-zA-Z0-9]*$";
  public static final String regexRelationName = "^[a-z][a-zA-Z0-9\\.]*\\*?$";
  public static final String regexRecordRef = "^[a-z][a-zA-Z0-9]*$";
  public static final String regexRecordValue = "^[^ ]*$";
  public static final String regexExpressionLiteralKey = "^[0-9]+$";
  public static final String regexExpressionIdentifier = "[a-z][a-zA-Z0-9]*";
  public static final String regexFunctionSignature = "^[a-z][a-zA-Z0-9]* \\([a-zA-Z0-9\\, ]*\\)$";
  public static final String regexFunctionBody = "^.*$";
  public static final String regexProcedureIterator = "for +[a-z][a-zA-Z0-9]* +in +[a-z][a-zA-Z0-9]*[ *\\. *[a-z][a-zA-Z0-9]*]*z";

  public Boolean isEmpty ()
  {
    return super.value ().isEmpty ();
  }

  private Boolean hasComment ()
  {
    return this.value ().indexOf (comment) > -1;
  }
  public String sansComment ()
  {
    if (this.hasComment ())
    {
      Integer index = this.value ().indexOf (comment);
      return this.value ().substring (0, index).trim ();
    }
    else return this.value ();
  }

  public Boolean isSector ()
  {
    return this.sansComment ().matches (regexSector);
  }
  public String sector ()
  {
    assert this.isSector ();
    String sector = this.sansComment ().substring (2);
    return sector;
  }

  private Boolean hasNeck ()
  {
    return this.sansComment ().contains (neck);
  }
  private String head ()
  {
    assert this.hasNeck ();
    return this.sansComment ().substring (0, this.sansComment ().indexOf (neck)).trim ();
  }
  private String body ()
  {
    assert this.hasNeck ();
    return this.sansComment ().substring (this.sansComment ().indexOf (neck) + 1).trim ();
  }

  public Boolean isRelation ()
  {
    if (this.hasNeck ())
    {
      Boolean is = this.head ().matches (regexRelationId);
      for (String s: this.body ().split (" "))
        is &= s.matches (regexRelationName);
      return is;
    }
    else return false;
  }
  public String relationId ()
  {
    assert this.isRelation ();
    return this.head ();
  }
  public List <String> relationNames ()
  {
    assert this.isRelation ();
    List <String> namez = new ArrayList <String> ();
    for (String name: this.body ().split (space)) namez.add (name);
    return namez;
  }

  public Boolean isRecord ()
  {
    if (this.hasNeck ())
    {
      Boolean ids = this.head ().matches (regexRecordRef);
      for (String s: this.body ().split (" "))
        ids &= s.matches (regexRecordValue);
      return ids;
    }
    else return false;
  }
  public String recordRef ()
  {
    assert this.isRecord (): "not Record: " + this.toString ();
    return this.head ();
  }
  public String recordRelationId ()
  {
    assert this.isRecord ();
    String ref = this.recordRef ();
    return ref.substring (0, 1).toUpperCase ()
    + ref.substring (1, ref.length ());
  }
  public List <String> recordValues ()
  {
    assert this.isRecord (): "not Record: " + this.toString ();
    List <String> valuez = new ArrayList <String> ();
    for (String value: this.body ().split (space)) valuez.add (value);
    return valuez;
  }

  public Boolean isFunction ()
  {
    if (this.hasNeck ())
      return this.head ().matches (regexFunctionSignature)
      && this.body ().matches (regexFunctionBody);
    else return false;
  }
  public String functionName ()
  {
    assert this.isFunction ();
    return this.head ().split (opener) [0].trim ();
  }
  public List <String> functionParamz ()
  {
    assert this.isFunction ();
    List <String> paramz = new ArrayList <String> ();
    for (String param: this.head ().split (opener) [1].split (closer) [0].split (comma)) paramz.add (param.trim ());
    return paramz;
  }
  public String functionBody ()
  {
    assert this.isFunction ();
    return this.body ();
  }

  public Boolean isIntroduction ()
  {
    return this.sansComment ().trim ().startsWith (procedureIntroducer);
  }

  public Boolean isIteration ()
  {
    return this.sansComment ().trim ().matches (regexProcedureIterator);
  }

  public Boolean isEnding ()
  {
    return this.sansComment ().trim ().equals (procedureEnding);
  }

  /*private Expression expression (String cleanment)
  {
    assert this.isFunction () || this.isIntroduction ();
    List <Token> tokens = Tokeniser.tokenisation (cleanment);
    Expression expression = Parser.parsing (tokens);
    return expression;
  }

  public Introduction introduction ()
  {
    assert this.isIntroduction ();
    Expression expression = expression (this.sansComment ().replaceFirst (procedureIntroducer, FSO.blank));
    Introduction introduction = new Introduction ();
    introduction.setExpression (expression);
    return introduction;
  }

  public Iteration iteration (List <Line> lines)
  {
    assert this.isIteration ();
    String [] sz = this.sansComment ().trim ().replaceAll (" +", " ").split (" ");
    String instance = sz [1];
    String qualifier = sz [3].contains (expressionDot)? sz [3].substring (0, sz [3].indexOf (expressionDot)): FSO.blank;
    String qualifiee =  sz [3].contains (expressionDot)? sz [3].substring (sz [3].indexOf (expressionDot) + 1, sz [3].length ()): sz [3];
    Iteration iteration = new Iteration ();
    iteration.setInstance (instance);
    iteration.setQualifier (qualifier);
    iteration.setQualifiee (qualifiee.replaceFirst ("z$", ""));
    iteration.setStatements (info.lrbh.codive.schema.procedure.Parser.parsing (lines));
    return iteration;
  }

  public Ending ending ()
  {
    return new Ending ();
  }*/

  /*public Boolean hasQuotation ()
  {
    Integer here = this.sansComment ().indexOf (FSO.quote);
    Integer there = this.sansComment ().indexOf (FSO.quote, here + 1);
    return here < there;
  }

  public String quotation ()
  {
    assert this.hasQuotation ();
    Integer here = this.sansComment ().indexOf (FSO.quote);
    Integer there = this.sansComment ().indexOf (FSO.quote, here + 1);
    return this.sansComment ().substring (here, there + 1);
  }

  public void replaceQuotation (String replacement)
  {
    assert this.hasQuotation ();
    Integer here = this.sansComment ().indexOf (FSO.quote);
    Integer there = this.sansComment ().indexOf (FSO.quote, here + 1);
    this.setString
    (
      this.sansComment ().substring (0, here)
      + replacement
      + this.sansComment ().substring (there + 1)
    );
  }

  public void clean (String commentMarker, Map <String, Symbol> symbols)
  {
    if (this.hasComment (commentMarker))
      this.removeComment (commentMarker);
    while (this.hasQuotation ())
    {
      String key = nextSymbolId (symbols).toString ();
      String unquoted = this.quotation ().substring (1, this.quotation ().length () - 1);
      this.replaceQuotation (key);
      Symbol symbol = new Symbol ();
      symbol.setName (key);
      symbol.setValue (unquoted);
      symbols.put (key, symbol);
    }
  }

  private static final Integer nextSymbolId (Map <String, Symbol> symbols)
  {
    String regex = regexExpressionLiteralKey;
    Integer nextId = 0;
    for (String key: symbols.keySet ())
      if (key.matches (regex))
        if (Integer.parseInt (key) > nextId)
          nextId = Integer.parseInt (key);
    return ++nextId;
  }

  public Boolean isSymbol ()
  {
    return this.hasNeck ()
    && this.head ().matches (regexSymbolName)
    && this.body ().matches (regexSymbolValue);
  }

  public Symbol symbol ()
  {
    assert this.isSymbol ();
    String name = this.head ();
    String value = this.body ();
    Symbol symbol = new Symbol ();
    symbol.setName (name);
    symbol.setValue (value);
    return symbol;
  }*/

}
