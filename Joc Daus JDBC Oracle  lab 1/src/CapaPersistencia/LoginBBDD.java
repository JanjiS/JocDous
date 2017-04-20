package CapaPersistencia;

import java.sql.Connection;

import CapaPersistencia.ConnectionBBDD;

public class LoginBBDD {
	
	private static Connection connection;
	
	public static void login(String user, String password) throws Exception{
		if(connection==null){
			connection=new ConnectionBBDD(user, password);
		}
	}
	
	static ConnectionBBDD getConnection() throws Exception {
		if(connection==null)
				throw new Exception ("No ha iniciat sessió");
		return (ConnectionBBDD) connection;
	}

}
