package service;

import model.Atendente;
import dao.AtendenteDAO;


public class AtendenteService {
	AtendenteDAO pdao = new AtendenteDAO();
	
	public int criar(Atendente atendente) {
		return pdao.criar(atendente);
	}
	
	public void atualizar(Atendente atendente){
		pdao.atualizar(atendente);
	}
	
	public Atendente carregar(int id){
		return pdao.carregar(id);
	}

}
