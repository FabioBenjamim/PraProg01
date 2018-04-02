package model;

public class PalavraChave {

	private int id;
	private String palavra;
	
	
	public PalavraChave(int id, String palavra) {
		this.id = id;
		this.palavra = palavra;
	}
	
	public PalavraChave() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPalavra() {
		return palavra;
	}


	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
	

	@Override
	public String toString() {
		return "PalavraChave [id=" + id + ", palavra=" + palavra + "]";
	}

	
}
