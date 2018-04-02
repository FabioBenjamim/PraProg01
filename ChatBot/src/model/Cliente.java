package model;

import java.io.Serializable;

public class Cliente implements Serializable{
	private static final long serialVersionUID =1;
	
	private int id_Cliente;
	private String nome_Cliente;
	private int cpf_Cliente;
	private String email_Cliente;
	private String telefone_Cliente;
	private String data_nascismento_Cliente;
	
	public Cliente() {
		
	}
	public void vetCliente() {
		
	}
	
	public int getId_Cliente() {
		return id_Cliente;
	}
	public void setId_Cliente(int id_Cliente) {
		this.id_Cliente = id_Cliente;
	}
	public String getNome_Cliente() {
		return nome_Cliente;
	}
	public void setNome_Cliente(String nome_Cliente) {
		this.nome_Cliente = nome_Cliente;
	}
	public int getCpf_Cliente() {
		return cpf_Cliente;
	}
	public void setCpf_Cliente(int cpf_Cliente) {
		this.cpf_Cliente = cpf_Cliente;
	}
	public String getEmail_Cliente() {
		return email_Cliente;
	}
	public void setEmail_Cliente(String email_Cliente) {
		this.email_Cliente = email_Cliente;
	}
	public String getTelefone_Cliente() {
		return telefone_Cliente;
	}
	public void setTelefone_Cliente(String telefone_Cliente) {
		this.telefone_Cliente = telefone_Cliente;
	}
	public String getData_nascismento_Cliente() {
		return data_nascismento_Cliente;
	}
	public void setData_nascismento_Cliente(String data_nascismento_Cliente) {
		this.data_nascismento_Cliente = data_nascismento_Cliente;
	}
	
	@Override
	public String toString() {
		return "Pais [id=" + id_Cliente + ", nome=" + nome_Cliente + ", cpf=" + 
				cpf_Cliente + ", emails=" + email_Cliente + ", telefone=" + 
				telefone_Cliente + ", Data_Nascismento" + data_nascismento_Cliente + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf_Cliente != other.cpf_Cliente)
			return false;
		if (data_nascismento_Cliente == null) {
			if (other.data_nascismento_Cliente != null)
				return false;
		} else if (!data_nascismento_Cliente.equals(other.data_nascismento_Cliente))
			return false;
		if (email_Cliente == null) {
			if (other.email_Cliente != null)
				return false;
		} else if (!email_Cliente.equals(other.email_Cliente))
			return false;
		if (id_Cliente != other.id_Cliente)
			return false;
		if (nome_Cliente == null) {
			if (other.nome_Cliente != null)
				return false;
		} else if (!nome_Cliente.equals(other.nome_Cliente))
			return false;
		if (telefone_Cliente == null) {
			if (other.telefone_Cliente != null)
				return false;
		} else if (!telefone_Cliente.equals(other.telefone_Cliente))
			return false;
		return true;
	}
	
	public void select(){
		
	}
	public void criar() {
		
	}
	
}
