package com.generation.ClientFlow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ClientFlow.model.Produto;
import com.generation.ClientFlow.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public List<Usuario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
	
	public Optional<Usuario> findByNome(@Param("nome")String nome);

}
