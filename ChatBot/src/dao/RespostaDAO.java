package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Resposta;


public class RespostaDAO {
	
	public int carregar(int id) {
		Resposta resposta = new Resposta();
		resposta.setId_Resposta(id);
		String sqlSelect = "SELECT resposta_Resposta  FROM Resposta WHERE resposta.id_Resposta = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, resposta.getId_Resposta());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					resposta.setResposta_Resposta(rs.getString("nome"));
					} else {
					resposta.setId_Resposta(-1);
					resposta.setResposta_Resposta(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return resposta.getId_Resposta();
	}
	
	

}