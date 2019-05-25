package com.waylau.h2.demos;

import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App{
	private static final Logger logger = LogManager.getLogger(App.class.getName());
    
    public static void main( String[] args ){
        try {
        	org.h2.tools.Server.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
