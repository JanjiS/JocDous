package CapaAplicacio;

import CapaPersistencia.LoginBBDD;

public class ControladorLogin {
	
	public boolean login(String username, String password){
		
		try {
			LoginBBDD.login(username, password);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}