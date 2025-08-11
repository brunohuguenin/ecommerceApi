package dev.bruno.ecommerceApi.service;


import dev.bruno.ecommerceApi.model.Produto;
import dev.bruno.ecommerceApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto criar(Produto produto) {
        if (produto.getId() != null) {
            throw new IllegalArgumentException("ID deve ser nulo para criar um novo produto");
        }
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produto) {
        Optional<Produto> existente = produtoRepository.findById(id);
        if (existente.isEmpty()) {
            throw new IllegalArgumentException("Produto não encontrado com ID: " + id);
        }
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new IllegalArgumentException("Produto não encontrado com ID: " + id);
        }
        produtoRepository.deleteById(id);
    }

}
