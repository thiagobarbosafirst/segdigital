package br.com.provasquadra.segdigital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.provasquadra.segdigital.entity.Sistema;

@Repository
public interface SistemaRepository extends JpaRepository<Sistema,Integer> {
	List<Sistema> findByDescricao(String descricao);
}


