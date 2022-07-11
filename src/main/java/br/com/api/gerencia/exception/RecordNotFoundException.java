package br.com.api.gerencia.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {
	private static final Logger LOGGER = LoggerFactory.getLogger(RecordNotFoundException.class);
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String mensagem) {
		super(mensagem);
		LOGGER.info("Estou passando na exception RecordNotFoundException");
		LOGGER.error(mensagem);
	}
}