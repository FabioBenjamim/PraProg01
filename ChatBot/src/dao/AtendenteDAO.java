package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Atendente;

public class AtendenteDAO {
	
	public int criar(Atendente atendente) {
		String sqlInsert = "INSERT INTO Palavra_Chave(nome_Atendente,cpf_Atendente) VALUES (?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, atendente.getNome());
			stm.setString(2, atendente.getCpf());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					atendente.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return atendente.getId();
	}
	
	public void atualizar(Atendente atendente) {
		String sqlUpdate = "UPDATE Palavra-Chave SET nome_Atendente=? , cpf_Atendente=? WHERE atendente.id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, atendente.getNome());
			stm.setString(2, atendente.getCpf());
			stm.setInt(3, atendente.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Atendente carregar(int id) {
		Atendente atendente = new Atendente();
		atendente.setId(id);
		String sqlSelect = "SELECT nome_Atendente,cpf_Atendente FROM Atendente WHERE atendente.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, atendente.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					atendente.setNome(rs.getString("Nome"));
					atendente.setCpf(rs.getString("CPF"));
				} else {
					atendente.setId(-1);
					atendente.setNome(null);
					atendente.setCpf(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return atendente;
	}

	
}

