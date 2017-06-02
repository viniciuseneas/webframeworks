package br.unipe.pos.web.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "contato")
public class ContatoModel implements Serializable {
	
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer id;
	@NotBlank(message = "*Nome é uma informação obrigatória.")
	@NotEmpty(message = "*Nome é uma informação obrigatória.")
	@Column(name = "nome", nullable = false)
	private String nome;
	@NotBlank(message = "*Sobrenome é uma informação obrigatória.")
	@NotEmpty(message = "*Sobrenome é uma informação obrigatória.")
	@Column(name = "sobrenome", nullable = false)
	private String sobreNome;
	@NotBlank(message = "*Telefone é uma informação obrigatória.")
	@NotEmpty(message = "*Telefone é uma informação obrigatória.")
	@Column(name = "telefone", nullable = false)
	private String telefone;
	@Email(message = "*Informe um E-mail valido")
	@NotBlank(message = "*Email é uma informação obrigatória.")
	@NotEmpty(message = "*Email é uma informação obrigatória.")
	@Column(name = "email", nullable = false)
	private String email;
	@NotBlank(message = "*Idade é uma informação obrigatória.")
	@NotEmpty(message = "*Idade é uma informação obrigatória.")
	@Column(name = "idade", nullable = false)
	private Integer idade;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
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
	public Integer getIdade() {
		return idade;
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
