package com.waylau.h2.demos.server;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Server {
	private static final Logger logger = LogManager.getLogger(Server.class.getName());
    
    public static void main( String[] args ){
        /**
         不加任何参数 ，则默认启动三个服务器
         TCP server running at tcp:              //192.168.11.125:9092 (only local connections)
         PG server running at pg:                //192.168.11.125:5435 (only local connections)
         Web Console server running at            //192.168.11.125:8082 (only local connections)
         */
        try {
        	org.h2.tools.Server.main();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
