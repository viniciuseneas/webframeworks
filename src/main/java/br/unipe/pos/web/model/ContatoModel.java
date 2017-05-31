package br.unipe.pos.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tb_contato")
public class ContatoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "nome", nullable = false)
	@NotBlank(message = "Nome é uma informação obrigatória.")
	private String nome;
	@Column(name = "sobrenome", nullable = false)
	@NotBlank(message = "Sobrenome é uma informação obrigatória.")
	private String sobreNome;
	@Column(name = "telefone", nullable = false)
	@NotBlank(message = "Telefone é uma informação obrigatória.")
	private String telefone;
	@Column(name = "email", nullable = false)
	@NotBlank(message = "Email é uma informação obrigatória.")
	private String email;
	@Column(name = "idade", nullable = false)
	@NotBlank(message = "Idade é uma informação obrigatória.")
	private int idade;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the sobreNome
	 */
	public String getSobreNome() {
		return sobreNome;
	}

	/**
	 * @param sobreNome
	 *            the sobreNome to set
	 */
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	/**
	 * @return the telefone
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone
	 *            the telefone to set
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(int idade) {
		this.idade = idade;
	}

}
