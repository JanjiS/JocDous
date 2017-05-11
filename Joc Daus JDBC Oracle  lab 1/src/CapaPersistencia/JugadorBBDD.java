package CapaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CapaDomini.Jugador;

public class JugadorBBDD {
	public static Jugador getJugador(String nom) throws Exception{
		ConnectionBBDD connection= LoginBBDD.getConnection();
		
		try {
			
			String sql="SELECT * FROM JUGADOR WHERE NOM = ?";
			
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.clearParameters();
			preparedStatment.setString(1, nom);
			ResultSet rs = preparedStatment.executeQuery();
			
			while (rs.next()) {
				String nomTrobat;
				nomTrobat=rs.getString("NOM");
				return new Jugador(nomTrobat);
			}
			
			System.out.println("Jugador no trobat, crear un nou");
			throw new Exception ("No sha trobat el jugador");
		} catch (SQLException e) {
			throw new Exception ("Error al agafar el jugador", e);
		}
	}
	
	public static void createJugador(Jugador jugador) throws Exception {
 	    ConnectionBBDD connection= LoginBBDD.getConnection();
		
		try {
			
			String sql="INSERT INTO JUGADOR VALUES(?)";
			
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.clearParameters();
			preparedStatment.setString(1, jugador.getNom());
			
			if (preparedStatment.executeUpdate() !=1){
				throw new Exception ("Jugador no guardat");
			}
		} catch (SQLException e){
				throw new Exception ("Error al inserir el jugador");
		}
	}
}
