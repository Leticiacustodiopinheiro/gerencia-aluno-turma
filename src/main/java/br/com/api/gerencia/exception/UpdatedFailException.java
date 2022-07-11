package br.com.api.gerencia.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdatedFailException extends RuntimeException {
	private static final Logger LOGGER = LoggerFactory.getLogger(UpdatedFailException.class);
	private static final long serialVersionUID = 1L;

	public UpdatedFailException(String mensagem) {
		super(mensagem);
		LOGGER.info("Dados não Atualizados");
		LOGGER.error(mensagem);
	}
}