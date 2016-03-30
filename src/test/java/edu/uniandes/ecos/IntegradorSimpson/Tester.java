package edu.uniandes.ecos.IntegradorSimpson;

import edu.uniandes.ecos.IntegradorSimpson.modelo.IntegradorSimpson;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @name Tester
 * @author Juan
 * @version 1.0
 * @date 25/03/2015
 * @description clase encargada de ejecutar los test de prueba a traves de JUnit.
 */
public class Tester extends TestCase{

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Tester( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( Tester.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 1
     */
    @org.junit.Test
    public void test1(){
        
       try {
            IntegradorSimpson integradorSimpson = new IntegradorSimpson(10, 9, 1.1);
            
            assertEquals(0.35006, integradorSimpson.redondear(integradorSimpson.integrar(), 5));
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 2
     */
    @org.junit.Test
    public void test2(){
        
       try {
            IntegradorSimpson integradorSimpson = new IntegradorSimpson(10, 10, 1.1812);
            
            assertEquals(0.36757, integradorSimpson.redondear(integradorSimpson.integrar(), 5));
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //method
    /**
     * Ejeucta el caso de prueba 3
     */
    @org.junit.Test
    public void test3(){
        
       try {
            IntegradorSimpson integradorSimpson = new IntegradorSimpson(10, 30, 2.750);
            
            assertEquals(0.49500, integradorSimpson.redondear(integradorSimpson.integrar(), 5));
        } catch (Exception ex) {
            fail(ex.getMessage());
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


