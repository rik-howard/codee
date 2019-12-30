
package connecting;

import connecting.connectee.Nonarian;
import connecting.connector.Unarian;
import connecting.connector.Binarian;
//import connecting.connector.Ternarian;

public interface Connectable
{

  public static final Connectee truth = new Nonarian ("true");
  public static final Connectee falsity = new Nonarian ("false");
  public static final Connector egator = new Unarian ("ot", "pre");
  public static final Connector negator = new Unarian ("not", "pre");
  public static final Connector unitautologiser = new Unarian ("isa", "pre");
  public static final Connector unifalliciser = new Unarian ("nisa", "pre");
  public static final Connector universaliser = new Binarian ("each", "pre");
  public static final Connector existentialiser = new Binarian ("some", "pre");
  public static final Connector disjoiner = new Binarian ("or", "in");
  public static final Connector nisjoiner = new Binarian ("nor", "in");
  public static final Connector conjoiner = new Binarian ("and", "in");
  public static final Connector nonjoiner = new Binarian ("nand", "in");
  public static final Connector disditor = new Binarian ("if", "in");
  public static final Connector nisditor = new Binarian ("nif", "in");
  public static final Connector conditor = new Binarian ("oif", "in");
  public static final Connector nonditor = new Binarian ("noif", "in");
  public static final Connector biconditor = new Binarian ("iff", "in");
  public static final Connector niconditor = new Binarian ("niff", "in");
  public static final Connector disferrer = new Binarian ("ov", "in");
  public static final Connector nisferrer = new Binarian ("nov", "in");
  public static final Connector conferrer = new Binarian ("az", "in");
  public static final Connector nonferrer = new Binarian ("naz", "in");
  public static final Connector binitautologiser = new Binarian ("isa", "in");
  public static final Connector binifalliciser = new Binarian ("nisa", "in");
  public static final Connector okayer = new Binarian ("isso", "in");
  public static final Connector yakoer = new Binarian ("isno", "in");

}
