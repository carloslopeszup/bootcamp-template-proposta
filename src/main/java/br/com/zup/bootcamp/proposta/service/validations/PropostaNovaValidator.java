package br.com.zup.bootcamp.proposta.service.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.zup.bootcamp.proposta.entity.dto.PropostaDTO;
import br.com.zup.bootcamp.proposta.resource.exception.FieldMessage;
import br.com.zup.bootcamp.proposta.util.CpfCnpj;

public class PropostaNovaValidator implements ConstraintValidator<PropostaNova, PropostaDTO> {

	@Override
	public void initialize(PropostaNova contraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(PropostaDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(!CpfCnpj.isValidaCpfCnpj(objDto.getCpfCnpj())) {
			list.add(new FieldMessage("CpfCnpj", "Cpf ou CNPJ Inválido"));
		}
		
		for( FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
		}
		return list.isEmpty();	}

}
