package com.generation.ClientFlow.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.ClientFlow.model.Produtos;
import com.generation.ClientFlow.repository.ProdutosRepository;
import com.generation.ClientFlow.service.ProdutosService;
import com.generation.ClientFlow.repository.CategoriaRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutosService produtoService;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/nome/{Nome}")
	public ResponseEntity<List<Produtos>> getByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produto){
	    if (categoriaRepository.existsById(produto.getCategoria().getId()))
	        return ResponseEntity.status(HttpStatus.CREATED)
	            .body(produtoRepository.save(produto));

	    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!",null);
	}

	
	@PostMapping("/verifica-oportunidade/{id}")
	public ResponseEntity<Optional<Produtos>> post(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.CREATED)
	            .body(produtoService.verificarOportunidadeProduto(id));
	} 
	 
	
	
	@PutMapping
	public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produto) {
	    if (produtoRepository.existsById(produto.getId())) {
	        if (categoriaRepository.existsById(produto.getCategoria().getId())) {
	            return ResponseEntity.status(HttpStatus.OK)
	                .body(produtoRepository.save(produto));
	        }
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria não existe!",null);
	    }
	    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
	    Optional<Produtos> produto = produtoRepository.findById(id);

	    if (produto.isEmpty())
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

	    produtoRepository.deleteById(id);
	}

	
	
	

}