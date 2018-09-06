package br.com.provasquadra.segdigital.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.provasquadra.segdigital.dto.SistemaDTO;
import br.com.provasquadra.segdigital.entity.Sistema;
import br.com.provasquadra.segdigital.service.SistemaBO;

@RestController
@RequestMapping("/sistema")
public class SistemaController {
	
	private SistemaBO sistemaService;
	@Autowired
	public SistemaController(SistemaBO sistemaService) {
		this.sistemaService = sistemaService;
	}
	
	@GetMapping("/getAllSistemas")
	public List<Sistema> getAllSistema() {
		return sistemaService.findAll();
	}
	
	@GetMapping("/getSistemas/{descricao}")
	public List<Sistema> getDescricao(@PathVariable String descricao) {
		return sistemaService.findByDescricao(descricao);
	}
	
	@PostMapping("/saveSistema")
	public void createSistema(@RequestBody SistemaDTO sistemaDTO) throws Exception {
		try {
			sistemaService.saveSistema(sistemaDTO);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
