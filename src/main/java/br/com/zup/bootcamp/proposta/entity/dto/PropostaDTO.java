package br.com.zup.bootcamp.proposta.entity.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import br.com.zup.bootcamp.proposta.service.validations.PropostaNova;

@PropostaNova
public class PropostaDTO {

	@NotBlank(message="Preenchimento nome é obrigatório")
	private String nome;
	
	@Email
	@NotBlank(message="Preenchimento email é obrigatório")
	private String email;
	
	@NotBlank(message="Preenchimento cpf ou cnpj é obrigatório")
	private String cpfCnpj;
	
	@Positive
	private Double salario;
	private String rua;
	private String bairro;
	private String cidade;
	@NotBlank(message="Preenchimento CEP é obrigatório")
	private String cep;
	@NotBlank(message="Preenchimento numero da casa é obrigatório")
	private String numero;

	public PropostaDTO() {
		super();
	}

	public PropostaDTO(String nome, String email, Double salario, String rua, String bairro, String cidade, String cep,
			String numero) {
		super();
		this.nome = nome;
		this.email = email;
		this.salario = salario;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.numero = numero;
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	
}
