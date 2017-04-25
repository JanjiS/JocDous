package CapaPersistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import CapaDomini.Partida;
import CapaPersistencia.ConnectionBBDD;
import CapaPersistencia.LoginBBDD;

public class PartidaBBDD {
	private static Partida partida;
	
	
	
//	public static coin getCoin(String coinType) throws Exception{
//		ConnectionBBDD connection= LoginBBDD.getConnection();
//		
//		try {
//			
//			String sql="SELECT * FROM COINS WHERE TYPE_COIN = ?";
//			
//			PreparedStatement preparedStatment = connection.prepareStatement(sql);
//			preparedStatment.clearParameters();
//			preparedStatment.setString(1, coinType);
//			ResultSet rs = preparedStatment.executeQuery();
//			
//			while (rs.next()) {
//				String type;
//				int value;
//				
//				type=rs.getString("TYPE_COIN");
//				value=rs.getInt("VALUE");
//				return new coin(value,type);
//			}
//			
//			throw new Exception ("No sha trobat la moneda");
//		} catch (SQLException e) {
//			throw new Exception ("Error al agafar la moneda", e);
//		}
//	
//		
//	}
	public void storeCoin (Partida partida) throws Exception{
		
		ConnectionBBDD connection = LoginBBDD.getConnection();
		try{
			
		
		String sql="UPDATE COINS SET VALUE = ? WHERE TYPE_COIN = ?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, coin.getType());
		pst.setInt(2, coin.getValue());
		
		if (pst.executeUpdate() !=1){
			throw new Exception ("Moneda no guardada");
		}
			
		} catch (SQLException e){
			throw new Exception ("Error al inserir la moneda");
		}
	}
	
}
