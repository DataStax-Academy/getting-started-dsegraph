package com.datastax.academy;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.datastax.driver.dse.DseCluster.Builder;
import com.datastax.driver.dse.DseSession;

public class TestsForDseGraphIT {
    
    /** Working Session. */
    static DseSession session;
    
    @BeforeClass    
    public static void connectionToDse() {
        Builder clusterConfig = new Builder();
        clusterConfig.addContactPoint("127.0.0.1");
        clusterConfig.withPort(9042);
        session = clusterConfig.build().connect("system");
    }
    
    @Test
    public void testWorkWithDse() {
        System.out.println("TEST: " + session.getLoggedKeyspace());
    }
    
    @AfterClass
    public static void closeConnection() {
        if (session != null) {
            session.getCluster().close();
        }
    }
    
    

}
