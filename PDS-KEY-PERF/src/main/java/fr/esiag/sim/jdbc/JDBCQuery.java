package fr.esiag.sim.jdbc;

import org.apache.log4j.Logger;

public class JDBCQuery {


	private final static Logger logger = Logger.getLogger(JDBCQuery.class); 
	
	
	public static boolean executeThisUpdateQuery(String request) {
		JDBCConnection mock = new JDBCConnection();
		try {
			logger.info("SQL : " + request);
			mock.executeThisUpdateQuery(request);
		} catch (JDBCException e) {
			logger.warn(e.toString());
			return false;
		}
		return true;
	}
	


}
