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
    public ProdutoDto criarProduto(ProdutoDto produtoDto) {
        if (produtoDto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        Produto produto = DozerConverter.parseObject(produtoDto, Produto.class);
        produto = produtoRepository.save(produto);
        return DozerConverter.parseObject(produto, ProdutoDto.class);
    }

    // Read (Listar todos)
    public List<ProdutoDto> listarProdutos() {
        List<Produto> produtos = produtoRepository.findAll();
        return DozerConverter.parseListObjects(produtos, ProdutoDto.class);
    }

    // Read (Buscar por ID)
    public ProdutoDto buscarProdutoPorId(Long id) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        return produtoOpt.map(produto -> DozerConverter.parseObject(produto, ProdutoDto.class)).orElse(null);
    }

    // Update
    public ProdutoDto atualizarProduto(ProdutoDto produtoAtualizado) {
        if (produtoAtualizado == null || produtoAtualizado.getId() == null) {
            throw new IllegalArgumentException("Produto ou ID não podem ser nulos");
        }
        if (produtoRepository.existsById(produtoAtualizado.getId())) {
            Produto produto = DozerConverter.parseObject(produtoAtualizado, Produto.class);
            produto = produtoRepository.save(produto);
            return DozerConverter.parseObject(produto, ProdutoDto.class);
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

