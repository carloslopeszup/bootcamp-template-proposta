package br.com.zup.bootcamp.proposta.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.bootcamp.proposta.entity.Proposta;
import br.com.zup.bootcamp.proposta.entity.dto.PropostaDTO;
import br.com.zup.bootcamp.proposta.service.PropostaService;

@RestController
@RequestMapping(value="/propostas")
public class PropostaResource {

	@Autowired
	private PropostaService propostaservice;
	
	@GetMapping
	public ResponseEntity<List<Proposta>> findByAll() throws Exception{
		return ResponseEntity.ok().body(propostaservice.listarPropostas());
	}
	
	@PostMapping
	public ResponseEntity<Proposta>cadastrarProposta(@RequestBody @Valid PropostaDTO propostaObj, 
																		 UriComponentsBuilder uriComponentsBuilder)throws Exception{
		
		Proposta proposta = propostaservice.salvarProposta(propostaObj);
		
		return ResponseEntity.created(uriComponentsBuilder.buildAndExpand("/propostas/{id}",
											proposta.getIdProposta()).toUri()).body(proposta);
	}
	
}
