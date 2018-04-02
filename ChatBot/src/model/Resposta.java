package model;

import java.io.Serializable;

public class Resposta implements Serializable{
	private static final long serialVersionUID =1;
	
	private int id_Resposta;
	private String resposta_Resposta;

	public String getResposta_Resposta() {
		return resposta_Resposta;
	}

	public void setResposta_Resposta(String resposta_Resposta) {
		this.resposta_Resposta = resposta_Resposta;
	}

	public int getId_Resposta() {
		return id_Resposta;
	}

	public void setId_Resposta(int id_Resposta) {
		this.id_Resposta = id_Resposta;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		if (id_Resposta != other.id_Resposta)
			return false;
		if (resposta_Resposta != other.resposta_Resposta)
			return false;
		return true;
	}
	public void select(){
		
	}
	

}
