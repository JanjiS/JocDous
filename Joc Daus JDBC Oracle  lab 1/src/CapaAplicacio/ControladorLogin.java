package CapaAplicacio;

import CapaPersistencia.LoginBBDD;

public class ControladorLogin {
	
	public void login() throws Exception{
		
		LoginBBDD.login("jjimenezs", "p39415315");
		
	}

}