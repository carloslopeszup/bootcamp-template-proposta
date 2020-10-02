package br.com.zup.bootcamp.proposta.resource.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<FieldMessage>list = new ArrayList<FieldMessage>();

	public ValidationError(Integer status, String msg, Long timeStamp, List<FieldMessage> list) {
		super(status, msg, timeStamp);
		this.list = list;
	}
	
	public List<FieldMessage>getErrors(){
		return list;
	}
	
	public void addError(String fieldName, String message) {
		list.add(new FieldMessage(fieldName, message));
	}
}
