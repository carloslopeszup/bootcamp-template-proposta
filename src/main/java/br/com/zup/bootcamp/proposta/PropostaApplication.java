package br.com.zup.bootcamp.proposta;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.bootcamp.proposta.entity.Proposta;
import br.com.zup.bootcamp.proposta.persistence.PropostaRepository;

@SpringBootApplication
public class PropostaApplication implements CommandLineRunner {

	@Autowired
	private PropostaRepository propostaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PropostaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Proposta proposta1 = new Proposta();
		proposta1.setIdProposta(null);
		proposta1.setEmail("carlos@gmail.com");
		proposta1.setNome("Carlos");
		proposta1.setSalario(2000.);
		
		Proposta proposta2 = new Proposta(null, "Renata", "renata@hotmail.com","11792993706", 5000.);
		Proposta proposta3 = new Proposta(null, "Alfredo", "Alfredo@hotmail.com","11940823781", 4000.);
		
		propostaRepository.saveAll(Arrays.asList(proposta1,proposta2,proposta3));
		
		
		
		
	}

}
