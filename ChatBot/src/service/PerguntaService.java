package service;

import dao.PerguntaDAO;
import model.Pergunta;


public class PerguntaService {
	PerguntaDAO dao = new PerguntaDAO();
	
	public int criar(Pergunta pergunta) {
		return dao.criar(pergunta);
	}
	public Pergunta carregar(int id_Pergunta) {
		return dao.carregar(id_Pergunta);
	}
	

}
