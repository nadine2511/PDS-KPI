package fr.esiag.sim.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class JDBCConnection {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/sim_staging";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "simmdp";

	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;

	static Logger logger = Logger.getLogger(JDBCConnection.class);

	public void setPreparedStatement(PreparedStatement p) {
		this.preparedStatement = p;
	}

	public void setConnection(Connection c) {
		this.dbConnection = c;
	}

	
	public boolean executeThisUpdateQuery(String query) throws JDBCException {
		try {
			dbConnection = getConnection();
			dbConnection.setAutoCommit(false);
			preparedStatement = dbConnection.prepareStatement(query);
			preparedStatement.executeUpdate();
			dbConnection.commit();
		} catch (SQLException e) {
			try {
				dbConnection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return false;
			}
			throw new JDBCException(e);

		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	
	
	public List<List<String>> resultSelectQuery(String query)
			throws JDBCException {
		List<List<String>> result = new ArrayList<List<String>>(); 
															
		ResultSet resultset;														

		try {
			dbConnection = getConnection();
			dbConnection.setAutoCommit(false);
			resultset = dbConnection.createStatement().executeQuery(query);
			ResultSetMetaData metadata = resultset.getMetaData();
			int numcols = metadata.getColumnCount();
			
			while (resultset.next()) {
				List<String> row = new ArrayList<String>(numcols); 
				int i = 1;
				while (i <= numcols) {
					String value = resultset.getString(i++);
					row.add(value);
				}
				result.add(row); 
			}
			return result;

		} catch (SQLException e) {

			try {
				dbConnection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new JDBCException(e);

		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


	}
	
	
	public Connection getConnection() throws SQLException {

		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println(e);

		}

		try {

			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e);
			throw new SQLException(e);

		}

	}
}
