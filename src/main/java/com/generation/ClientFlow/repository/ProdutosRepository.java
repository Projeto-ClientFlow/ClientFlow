package com.generation.ClientFlow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ClientFlow.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long>{

	public Optional<Produtos> findByNome(@Param("nome") String nome);
	
	public List<Produtos> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
