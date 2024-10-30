package Projeto.Petshop.SitemaPetShop.service;
import Projeto.Petshop.SitemaPetShop.entity.Produto;
import Projeto.Petshop.SitemaPetShop.service.ProdutoService;
import Projeto.Petshop.SitemaPetShop.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    // Outros métodos de serviço
}

