package service;

import dao.RespostaDAO;

public class RespostaService {
	RespostaDAO dao = new RespostaDAO();
	
	public int carregar(int id_Resposta) {
		return dao.carregar(id_Resposta);
	}

}
