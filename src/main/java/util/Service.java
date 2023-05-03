package main.java.util;

import main.java.util.myinterface.IDbConnector;

// This class is implementation of Inversion of Control
// This is implemented as a registry of external service being used


public class Service {
	private static IDbConnector dbConnector;
	
	public static IDbConnector getDbConnector() {
		if (dbConnector == null) {
			return MySqlDBConnector.getDbConnector();
		} else {
			return dbConnector;
		}
	}
}
