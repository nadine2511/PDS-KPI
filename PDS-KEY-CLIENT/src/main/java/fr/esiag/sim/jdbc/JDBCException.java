package fr.esiag.sim.jdbc;

public class JDBCException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public JDBCException() { super(); }
	public JDBCException(String message) { super(message); }
	public JDBCException(String message, Throwable cause) { super(message, cause); }
	public JDBCException(Throwable cause) { super(cause); }
}
