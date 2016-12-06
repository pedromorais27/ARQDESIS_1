package br.com.usjt.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessoBD {
	{     
		try{        
			Class.forName("com.mysql.jdbc.Driver");   
		} catch (ClassNotFoundException e){          
			throw new RuntimeException(e);     
		}  
	}  
	public Connection connection() throws SQLException{       
		return DriverManager.getConnection ("jdbc:mysql://localhost/projeto?user=root" );   
	}
}