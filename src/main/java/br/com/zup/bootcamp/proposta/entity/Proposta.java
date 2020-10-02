package br.com.zup.bootcamp.proposta.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Proposta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idProposta;
	private String nome;
	private String email;
	private String cpfCnpj;
	private Double salario;
	
	@OneToOne
	@JoinColumn(name="endereco_id")
	private Endereco endereco;
	
	public Proposta() {
		super();
	}
	
	public Proposta(Long idProposta, String nome, String email, String cpfCnpj, Double salario) {
		super();
		this.idProposta = idProposta;
		this.nome = nome;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.salario = salario;
	}
	@Override
	public String toString() {
		return "Proposta [idProposta=" + idProposta + ", nome=" + nome + ", email=" + email + ", salario=" + salario
				+ "]";
	}
	public Long getIdProposta() {
		return idProposta;
	}
	public void setIdProposta(Long idProposta) {
		this.idProposta = idProposta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
}	
