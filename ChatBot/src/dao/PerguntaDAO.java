package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Pergunta;


public class PerguntaDAO {
	
public int criar(Pergunta pergunta) {
		
		String sqlInsert = "INSERT INTO pergunta (pergunta_Pergunta) VALUES (?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, pergunta.getPergunta_Pergunta());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					pergunta.setId_Pergunta(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pergunta.getId_Pergunta();
	}
	
	public Pergunta carregar(int id) {
		Pergunta pergunta = new Pergunta();
		pergunta.setId_Pergunta(id);
		String sqlSelect = "SELECT pergunta_Pergunta  FROM Pergunta WHERE pergunta.id_Pergunta = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, pergunta.getId_Pergunta());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					pergunta.setPergunta_Pergunta(rs.getString("Pergunta"));
					} else {
					pergunta.setId_Pergunta(-1);
					pergunta.setPergunta_Pergunta(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return pergunta;
	}

	

}