package br.com.zup.bootcamp.proposta.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.bootcamp.proposta.entity.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {

	Proposta findByCpfCnpj(String cpfCnpj);
}
