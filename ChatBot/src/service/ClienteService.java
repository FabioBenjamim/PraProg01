package service;

import model.Cliente;
import dao.ClienteDAO;

public class ClienteService {
	ClienteDAO dao = new ClienteDAO();
	
	
	public int criar(Cliente cliente) {
		return dao.criar(cliente);
	}
	public int carregar(int id_Cliente) {
		return dao.carregar(id_Cliente);
	}
	
}
