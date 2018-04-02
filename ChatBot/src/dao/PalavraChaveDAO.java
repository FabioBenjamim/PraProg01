package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.PalavraChave;

public class PalavraChaveDAO {
	
	public int criar(PalavraChave palavrachave) {
		String sqlInsert = "INSERT INTO Palavra_Chave(palavra_Palavra) VALUES (?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, palavrachave.getPalavra());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					palavrachave.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return palavrachave.getId();
	}
	
	public void atualizar(PalavraChave palavrachave) {
		String sqlUpdate = "UPDATE Palavra-Chave SET palavra_Palavra=? WHERE palavra_chave.id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, palavrachave.getPalavra());
			stm.setInt(2, palavrachave.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public PalavraChave carregar(int id) {
		PalavraChave palavrachave = new PalavraChave();
		palavrachave.setId(id);
		String sqlSelect = "SELECT palavra_Palavra FROM Palavra-Chave WHERE palavra_chave.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, palavrachave.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					palavrachave.setPalavra(rs.getString("Palavra"));
				} else {
					palavrachave.setId(-1);
					palavrachave.setPalavra(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return palavrachave;
	}

	
}

