package com.generation.ClientFlow.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.generation.ClientFlow.model.Produtos;
import com.generation.ClientFlow.repository.ProdutosRepository;

@Service
public class ProdutosService {

	@Autowired
    private ProdutosRepository produtoRepository;
 
	
	  // Método para cadastrar um novo produto
    public Optional<Produtos> cadastrarProduto(Produtos produto) {
        // Verifica se já existe um produto com o mesmo nome
        if (produtoRepository.findAllByNomeContainingIgnoreCase(produto.getNome()).isPresent()) {
            return Optional.empty(); // Produto já existe
        }
        // Salva e retorna o produto cadastrado
        return Optional.of(produtoRepository.save(produto));
    }

    // Método para Atualizar produto
    public Optional<Produtos> atualizarProduto(Produtos produto) {

        if (produtoRepository.findById(produto.getId()).isPresent()) { // Verifica se o produto existe

            Optional<Produtos> buscaProdutos = produtosRepository.findAllByNomeContainingIgnoreCase(produto.getNome());

            if (buscaProdutos.isPresent() && !buscaProdutos.get().getId().equals(produto.getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto já existe!", null);
            }

            return Optional.ofNullable(produtoRepository.save(produto)); // Salva e retorna o produto atualizado
        }

        return Optional.empty(); // Retorna vazio se o produto não existir
    
    }
 // Função especial: Verificar oportunidade com base no valor do contrato
    public Optional<Produtos> verificarOportunidadeProduto(Optional<Produtos> produtos) {
        
        // Verifica se o produto foi passado corretamente
        if (produtos.isPresent()) {
            Produtos produtoEncontrado = produtos.get();

            //  Se o valor do contrato for maior que 10.000, a oportunidade é convertida
            if (produtoEncontrado.getValorContrato() > 10000) {
                
                // Atualiza o status da oportunidade para true
                produtoEncontrado.setStatusOportunidade(true);
                
                // Exibe no console que a oportunidade foi convertida
                System.out.println("Oportunidade CONVERTIDA para o produto: " + produtoEncontrado.getNome());
                
                // Salva as alterações no produto
                produtoRepository.save(produtoEncontrado);
                
                // Retorna o produto atualizado
                return Optional.of(produtoEncontrado);
            } else {
                // Exibe no console que a oportunidade não foi convertida
                System.out.println("Oportunidade NÃO convertida. Valor do contrato muito baixo.");
                
            }
        
}