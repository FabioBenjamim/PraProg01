package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Cliente;



public class ClienteDAO {
	
	public int criar(Cliente cliente) {
		String sqlInsert = "INSERT INTO cliente(nome_cliente, cpf_cliente, email_cliente, email_cliente, telefone_cliente, data_nascismento_cliente) VALUES (?, ?, ?, ?, ?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, cliente.getNome_Cliente());
			stm.setInt(2, cliente.getCpf_Cliente());
			stm.setString(3, cliente.getEmail_Cliente());
			stm.setString(4, cliente.getTelefone_Cliente());
			stm.setString(5, cliente.getData_nascismento_Cliente());
			stm.execute();
			String sqlQuery  = "SELECT LAST_INSERT_ID()";
			try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
				if(rs.next()){
					cliente.setId_Cliente(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente.getId_Cliente();
	}
	
	public int carregar(int id) {
		Cliente cliente = new Cliente();
		cliente.setId_Cliente(id);
		String sqlSelect = "SELECT nome_cliente, cpf_cliente, email_cliente, telefone_cliente, data_nascismento_cliente FROM pais WHERE cliente.id_cliente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, cliente.getId_Cliente());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente.setNome_Cliente(rs.getString("nome_cliente"));
					cliente.setCpf_Cliente(rs.getInt("cpf_cliente"));
					cliente.setEmail_Cliente(rs.getString("email_cliente"));
					cliente.setTelefone_Cliente(rs.getString("telefone_cliente"));
					cliente.setData_nascismento_Cliente(rs.getString("data_nascismento_cliente"));
					} else {
					cliente.setId_Cliente(-1);
					cliente.setNome_Cliente(null);
					cliente.setCpf_Cliente(0);
					cliente.setEmail_Cliente(null);
					cliente.setTelefone_Cliente(null);
					cliente.setData_nascismento_Cliente(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return cliente.getId_Cliente();
	}
	
	

}
