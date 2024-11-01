package Projeto.Petshop.SistemaPetShop.service;


import Projeto.Petshop.SistemaPetShop.data.dto.ProdutoDto;
import Projeto.Petshop.SistemaPetShop.data.dto.UsuarioDto;
import Projeto.Petshop.SistemaPetShop.data.model.Produto;
import Projeto.Petshop.SistemaPetShop.dozer.DozerConverter;
import Projeto.Petshop.SistemaPetShop.repository.ProdutoRepository;
import Projeto.Petshop.SistemaPetShop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Create
    public ProdutoDto criarProduto(ProdutoDto produto) {
        produtoRepository.save(DozerConverter.parseObject(produto,Produto.class));
        return produto;
    }

    // Read (Listar todos)
    public List<ProdutoDto> listarProdutos() {
        return DozerConverter.parseListObjects(produtoRepository.findAll(),ProdutoDto.class);
    }

    // Read (Buscar por ID)
    public ProdutoDto buscarProdutoPorId(Long id) {
        if (produtoRepository.existsById(id)){
            return DozerConverter.parseObject(produtoRepository.findById(id),ProdutoDto.class);
        }
        return null;
    }

    // Update
    public ProdutoDto atualizarProduto(ProdutoDto produtoAtualizado) {
        if (produtoRepository.existsById(produtoAtualizado.getId())) {
            var produto = DozerConverter.parseObject(produtoAtualizado, Produto.class);
            produtoRepository.save(produto);
            return produtoAtualizado;
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


