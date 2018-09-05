package br.com.provasquadra.segdigital.converter;

import br.com.provasquadra.segdigital.dto.SistemaDTO;
import br.com.provasquadra.segdigital.entity.Sistema;

public class SistemaConverter {
	public static Sistema dtoToEntity(SistemaDTO sistemaDTO) {
		Sistema sistema = new Sistema();
		sistema.setDescricao(sistemaDTO.getDescricao());
		sistema.setSigla(sistemaDTO.getSigla());
		sistema.setEmail(sistemaDTO.getEmail());
		sistema.setUrl(sistemaDTO.getUrl());
		sistema.setStatus(sistemaDTO.getStatus());
		
		return sistema;		
	}
	public static SistemaDTO entityToDto(Sistema sistema ) {
		SistemaDTO sistemaDTO = new SistemaDTO();
		sistemaDTO.setDescricao(sistema.getDescricao());
		sistemaDTO.setSigla(sistema.getSigla());
		sistemaDTO.setEmail(sistema.getEmail());
		sistemaDTO.setUrl(sistema.getUrl());
		sistema.setStatus(sistemaDTO.getStatus());
		
		return sistemaDTO;
	}
}
