package br.com.provasquadra.segdigital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.provasquadra.segdigital.Utils.ValidaEmail;
import br.com.provasquadra.segdigital.converter.SistemaConverter;
import br.com.provasquadra.segdigital.dto.SistemaDTO;
import br.com.provasquadra.segdigital.entity.Sistema;
import br.com.provasquadra.segdigital.repository.SistemaRepository;

@Service
public class SistemaBO {

	private SistemaRepository sistemaRepository;
	
	@Autowired
	public SistemaBO(SistemaRepository sistemaRepository){
		this.sistemaRepository = sistemaRepository;
	}
	
	public void saveSistema(SistemaDTO sistemaDTO) {
		if (ValidaEmail.isEmailValido(sistemaDTO.getEmail())) {
			sistemaRepository.save(SistemaConverter.dtoToEntity(sistemaDTO));
		} else {
			throw new IllegalStateException("Não foi salvo, e-mail inválido");
		}
			
	}
	
	public List<Sistema> findAll() {
		return sistemaRepository.findAll();
	}

	public List<Sistema> findByDescricao(String descricao) {
		return sistemaRepository.findByDescricao(descricao);
	}
}
