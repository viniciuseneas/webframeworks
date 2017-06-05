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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer id;
	@NotBlank
	@NotEmpty
	@Column(name = "nome", nullable = false)
	private String nome;
	@NotBlank
	@NotEmpty
	@Column(name = "sobrenome", nullable = false)
	private String sobreNome;
	@NotBlank
	@NotEmpty
	@Column(name = "telefone", nullable = false)
	private String telefone;
	@Email
	@NotBlank
	@NotEmpty
	@Column(name = "email", nullable = false)
	private String email;
	@NotBlank
	@NotEmpty
	@Column(name = "idade", nullable = false)
	private String idade;

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
	public String getIdade() {
		return idade;
	}

	/**
	 * @param idade
	 *            the idade to set
	 */
	public void setIdade(String idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {

		return "Contato{id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", email=" + email + ", telefone="
				+ telefone + ", idade=" + idade + "}";
	}
}
