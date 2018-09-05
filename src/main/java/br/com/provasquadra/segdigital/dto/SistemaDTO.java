package br.com.provasquadra.segdigital.dto;

public class SistemaDTO {
	Integer id;
	private String descricao;
	private String sigla;
	private String email;
	private String url;
	private String status;
	
	public SistemaDTO() {
	}
	
	public SistemaDTO(Integer id, String descricao, String sigla, String email, String url, String status) {
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
		this.email = email;
		this.url = url;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
