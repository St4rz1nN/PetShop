package Projeto.Petshop.SistemaPetShop.service;


import Projeto.Petshop.SistemaPetShop.data.model.Produto;
import Projeto.Petshop.SistemaPetShop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Create
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Read (Listar todos)
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // Read (Buscar por ID)
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Update
    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        if (produtoRepository.existsById(id)) {
            produtoAtualizado.setId(id);
            return produtoRepository.save(produtoAtualizado);
        }
        return null;
    }

    // Delete
    public boolean deletarProduto(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}


