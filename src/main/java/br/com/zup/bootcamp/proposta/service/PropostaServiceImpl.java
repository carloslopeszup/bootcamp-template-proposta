package br.com.zup.bootcamp.proposta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.bootcamp.proposta.entity.Endereco;
import br.com.zup.bootcamp.proposta.entity.Proposta;
import br.com.zup.bootcamp.proposta.entity.dto.PropostaDTO;
import br.com.zup.bootcamp.proposta.exception.UnprocessableEntityException;
import br.com.zup.bootcamp.proposta.persistence.EnderecoRepository;
import br.com.zup.bootcamp.proposta.persistence.PropostaRepository;

@Service
public class PropostaServiceImpl implements PropostaService{

	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public List<Proposta> listarPropostas() {
		return propostaRepository.findAll();
	}

	@Override
	public Proposta salvarProposta(PropostaDTO propostaObj) throws UnprocessableEntityException {
		
		if(validaProposta(propostaObj) != null){
			throw new UnprocessableEntityException("Proposta já existe!");
		}
		
		Proposta proposta = fromDto(propostaObj);
		
		enderecoRepository.save(proposta.getEndereco());
		
		propostaRepository.save(proposta);
		
		return proposta;
	}

	@Override
	public Proposta listarUmaProposta(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Proposta fromDto(PropostaDTO propostaObj) {
		
		Proposta proposta = new Proposta(null, propostaObj.getNome(), 
											   propostaObj.getEmail(),
											   propostaObj.getCpfCnpj(),
											   propostaObj.getSalario());
		
		Endereco endereco = new Endereco(null, 
										 propostaObj.getRua(), 
										 propostaObj.getBairro(), 
										 propostaObj.getCidade(), 
										 propostaObj.getCep(), 
										 propostaObj.getNumero());
		
		proposta.setEndereco(endereco);
		
		return proposta;
	}
	
	public Proposta validaProposta(PropostaDTO objDto){
		
		return		 propostaRepository.findByCpfCnpj(objDto.getCpfCnpj());
	}
}
