package service;

import model.PalavraChave;
import dao.PalavraChaveDAO;


public class PalavraChaveService {
	PalavraChaveDAO pdao = new PalavraChaveDAO();
	
	public int criar(PalavraChave palavrachave) {
		return pdao.criar(palavrachave);
	}
	
	public void atualizar(PalavraChave palavrachave){
		pdao.atualizar(palavrachave);
	}
	
	public PalavraChave carregar(int id){
		return pdao.carregar(id);
	}

}
