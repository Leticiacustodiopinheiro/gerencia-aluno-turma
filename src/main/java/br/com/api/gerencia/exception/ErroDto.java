package br.com.api.gerencia.exception;

public class ErroDto {
	private String mensagem;
	private String campo;
	private String error;

	public ErroDto(String mensagem, String campo, String error) {
		this.mensagem = mensagem;
		this.campo = campo;
		this.error = error;
	}

	public String getMensagem() {
		return mensagem;
	}

	public String getCampo() {
		return campo;
	}

	public String getError() {
		return error;
	}
}