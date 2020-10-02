package br.com.zup.bootcamp.proposta.service;

import java.util.List;

import br.com.zup.bootcamp.proposta.entity.Proposta;
import br.com.zup.bootcamp.proposta.entity.dto.PropostaDTO;

public interface PropostaService {

	List<Proposta>listarPropostas();
	
	Proposta salvarProposta(PropostaDTO proposta);
	
	Proposta listarUmaProposta(Long id);
	
	Proposta fromDto(PropostaDTO propostaObj);
}
