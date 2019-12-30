package main;
import java.util.List;
import cleaning.Cleanment;
import tokenising.Tokenisement;
import parsing.Parsement;
import linking.Linkment;
import compiling.Compilement;

public class Factory
{

  public static final Cleanment cleanment (String value)
  {
    Cleanment cleanment = new Cleanment ();
    cleanment.setValue (value);
    return cleanment;
  }

  public static final Tokenisement tokenisement (List <String> tokens)
  {
    Tokenisement tokenisement = new Tokenisement ();
    tokenisement.setTokens (tokens);
    return tokenisement;
  }

  public static final Parsement parsement (String pivot, Parsement left, Parsement right)
  {
    Parsement parsement = new Parsement ();
    parsement.setPivot (pivot);
    parsement.setLeft (left);
    parsement.setRight (right);
    return parsement;
  }

  public static final Linkment linkment (String pivot, Linkment left, Linkment right)
  {
    Linkment linkment = new Linkment ();
    linkment.setPivot (pivot);
    linkment.setLeft (left);
    linkment.setRight (right);
    return linkment;
  }

  public static final Compilement compilement (List <String> values)
  {
    Compilement compilement = new Compilement ();
    compilement.setValues (values);
    return compilement;
  }

}
