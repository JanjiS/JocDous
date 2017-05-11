package CapaPersistencia;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CapaDomini.Jugador;
import CapaDomini.Partida;
import CapaPersistencia.ConnectionBBDD;
import CapaPersistencia.LoginBBDD;

public class PartidaBBDD {
	private static Partida partida;
	
	public static List<Partida> getPartides(String nom) throws Exception{
		ConnectionBBDD connection= LoginBBDD.getConnection();
		
		try {
			
			String sql="SELECT * FROM PARTIDA WHERE NOM = ?";
			
			PreparedStatement preparedStatment = connection.prepareStatement(sql);
			preparedStatment.clearParameters();
			preparedStatment.setString(1, nom);
			ResultSet rs = preparedStatment.executeQuery();
			List<Partida> partides = new ArrayList<Partida>();
			
			while (rs.next()) {
				partides.add((Partida) rs); //TODO MMMH
				return partides;
			}
			
			System.out.println("Partides no trobades");
			throw new Exception ("No sha trobat les partides");
		} catch (SQLException e) {
			throw new Exception ("Error al agafar les partides", e);
		}
	}
	
	public void storePartida (Partida partida, Jugador jugador) throws Exception{
		
		ConnectionBBDD connection = LoginBBDD.getConnection();
		try{
			
		
		String sql="INSERT INTO JUGADOR VALUES(?,?,?,?)";
		String sql2="SELECT NEXT VALUE FOR S_IDPARTIDA";
		PreparedStatement pst = connection.prepareStatement(sql);
		PreparedStatement pst2 = connection.prepareStatement(sql2);
		ResultSet rs = pst2.executeQuery();
		int val = ((Number) rs.getObject(1)).intValue();
		
		pst.setString(1, jugador.getNom());
		pst.setInt(2, partida.getDau1());
		pst.setInt(3, partida.getDau2());
		pst.setInt(4, val);
		
		
		if (pst.executeUpdate() !=1){
			throw new Exception ("Partida no guardada");
		}
			
		} catch (SQLException e){
			throw new Exception ("Error al inserir la partida");
		}
	}
}
