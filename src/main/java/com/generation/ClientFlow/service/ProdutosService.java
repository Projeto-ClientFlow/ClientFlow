package com.generation.ClientFlow.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.generation.ClientFlow.model.Produto;
import com.generation.ClientFlow.repository.ProdutoRepository;

@Service
public class ProdutosService {

	@Autowired
	private ProdutoRepository produtoRepository;

	// Método para cadastrar um novo produto
	public Optional<Produto> cadastrarProduto(Produto produto) {
		// Verifica se já existe um produto com o mesmo nome
		if (produtoRepository.findByNome(produto.getNome()).isPresent()) {
			return Optional.empty(); // Produto já existe
		}
		// Salva e retorna o produto cadastrado
		return Optional.of(produtoRepository.save(produto));
	}

	// Método para Atualizar produto
	public Optional<Produto> atualizarProduto(Produto produto) {

		if (produtoRepository.findById(produto.getId()).isPresent()) { // Verifica se o produto existe

			Optional<Produto> buscaProduto = produtoRepository.findByNome(produto.getNome());

			if (buscaProduto.isPresent() && !buscaProduto.get().getId().equals(produto.getId())) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto já existe!", null);
			}

			return Optional.ofNullable(produtoRepository.save(produto)); // Salva e retorna o produto atualizado
		}

		return Optional.empty(); // Retorna vazio se o produto não existir
	}

	// Função especial: Verificar oportunidade com base no valor do contrato
	public Optional<Object> verificarOportunidadeProduto(Long id) {

		Optional<Produto> produto = produtoRepository.findById(id);

		// Verifica se o produto foi passado corretamente
		if (produto.isPresent()) {
			Produto produtoEncontrado = produto.get();

			// Se o valor do contrato for maior que 10.000, a oportunidade é convertida
			if (produtoEncontrado.getValorContrato() > 10000) {

				produtoEncontrado.setPontoFocal(produtoEncontrado.getPontoFocal() + " - VIP");
				// Salva as alterações no produto
				produtoRepository.save(produtoEncontrado);

				// Retorna o produto atualizado
				return Optional.of(produtoEncontrado);

			}
		}
		return Optional.of("Oportunidade NÃO convertida. Valor do contrato muito baixo.");
	}
}
