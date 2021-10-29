package csp.DataBase;

import javax.naming.*;
import javax.sql.*;

public class CSP_JDBC {
	protected DataSource dataSource;
	private final String dataSource_lookup = "java:comp/env/jdbc/clothing_store";
	
	public CSP_JDBC() {
		try {
            Context context = new InitialContext();
            dataSource = (DataSource)context.lookup(dataSource_lookup);
        }catch (Exception e) {
            e.printStackTrace();
        }
	}
}
