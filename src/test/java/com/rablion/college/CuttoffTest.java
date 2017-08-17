package com.rablion.college;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CuttoffTest extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CuttoffTest( String testName ) {
        super( testName );
    }
	
	 /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( CuttoffTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testCuttoff() {
        assertTrue( false );
    }

}
