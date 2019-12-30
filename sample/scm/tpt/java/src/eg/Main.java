
package eg;

import java.sql.SQLException;
import eg.geo.Continent;
import eg.geo.Compass;
import eg.geo.Subcontinent;
import eg.geo.ContinentPersistor;
import eg.geo.CompassPersistor;
import eg.geo.SubcontinentPersistor;

public class Main
{

  private static ContinentPersistor continentPersistor = new ContinentPersistor ();
  private static CompassPersistor compassPersistor = new CompassPersistor ();
  private static SubcontinentPersistor subcontinentPersistor = new SubcontinentPersistor ();

  public static void main (String OPNCLS args)
  throws ClassNotFoundException, SQLException
  {
    use00 ();  // yooce, not yooze
    use01 ();
    use02 ();
    use03 ();
    show ("codee-sample main");
  }

  private static void use00 ()
  throws ClassNotFoundException, SQLException
  {
    Continent continent = new Continent ();
    continent.setCode ("k");
    continent.setName ("amerika");
    assert continent.getId () == 0;
    show (continent);
    continent = continentPersistor.insertion (continent);
    assert continent.getId () == 1;
    show (continent);
    continent.setCode ("m");
    continent.setName ("america");
    continent = continentPersistor.updating (continent);
    show (continent);
    continentPersistor.delete (continent);
  }

  private static void use01 ()
  throws ClassNotFoundException, SQLException
  {
    Continent continent = new Continent ();
    continent.setCode ("e");
    continent.setName ("europe");
    continent = continentPersistor.insertion (continent);
    continent.setCode ("s");
    continent.setName ("asia");
    continent = continentPersistor.insertion (continent);
    assert continentPersistor.selection ().size () == 2;
    for (Continent c: continentPersistor.selection ()) show (c);
    assert continent.equals (continentPersistor.selectionById (3));
    continentPersistor.delete (continentPersistor.selectionById (2));
    continentPersistor.delete (continentPersistor.selectionById (3));
  }

  private static void use02 ()
  throws ClassNotFoundException, SQLException
  {
    Continent continent = new Continent ();
    continent.setCode ("f");
    continent.setName ("africa");
    Compass compass = new Compass ();
    compass.setCode ("n");
    compass.setName ("northern");
    Subcontinent subcontinent = new Subcontinent ();
    subcontinent.setContinent (continent);
    subcontinent.setCompass (compass);
    try {subcontinent = subcontinentPersistor.insertion (subcontinent);}
    catch (SQLException e)
    {
      show ("oops");
      show (e.getMessage ());
      show ("we forgot to persist the parent records");
    }
    continent = continentPersistor.insertion (continent);
    compass = compassPersistor.insertion (compass);
    subcontinent = subcontinentPersistor.insertion (subcontinent);
    show (subcontinent);
    show ("that's better");
  }

  private static void use03 ()
  throws ClassNotFoundException, SQLException
  {
    Subcontinent subcontinent = subcontinentPersistor.selectionById (1);
    show (subcontinent);
    subcontinent.setContinent (continentPersistor.selectionById (subcontinent.getContinent ().getId ()));
    subcontinent.setCompass (compassPersistor.selectionById (subcontinent.getCompass ().getId ()));
    show (subcontinent);
  }

  private static void show (Object object)
  {
    System.out.println (object.toString ());
  }

}
