package model;

import java.io.Serializable;

public class Pergunta implements Serializable{
	
	private static final long serialVersionUID =1;
	
	
	
	private int id_Pergunta;
	private String pergunta_Pergunta;
	
	public Pergunta() {
		
	}
	
	public Pergunta(int id_Pergunta , String pergunta_Pergunta) {
		this.id_Pergunta = id_Pergunta;
		this.pergunta_Pergunta = pergunta_Pergunta;
	}
	
	public void vetPergunta() {
		
	}
	public int getId_Pergunta() {
		return id_Pergunta;
	}
	public void setId_Pergunta(int id_Pergunta) {
		this.id_Pergunta = id_Pergunta;
	}
	public String getPergunta_Pergunta() {
		return pergunta_Pergunta;
	}
	public void setPergunta_Pergunta(String pergunta_Pergunta) {
		this.pergunta_Pergunta = pergunta_Pergunta;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pergunta other = (Pergunta) obj;
		if (id_Pergunta != other.id_Pergunta)
			return false;
		if (pergunta_Pergunta == null) {
			if (other.pergunta_Pergunta != null)
				return false;
		} else if (!pergunta_Pergunta.equals(other.pergunta_Pergunta))
			return false;
		return true;
	}
	public void select(){
		
	}
	public void criar() {
		
	}
	

}
