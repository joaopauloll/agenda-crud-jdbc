package agenda.model;

import java.io.Serializable;
import java.util.Date;

public class Contato implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private int idade;
	private Date dataCadastro;

	public Contato() {
	}

	public Contato(String nome, int idade, Date dataCadastro) {
		this.nome = nome;
		this.idade = idade;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
