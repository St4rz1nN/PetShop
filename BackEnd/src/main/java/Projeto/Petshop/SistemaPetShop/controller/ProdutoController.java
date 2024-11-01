package Projeto.Petshop.SistemaPetShop.controller;

import Projeto.Petshop.SistemaPetShop.data.dto.ProdutoDto;
import Projeto.Petshop.SistemaPetShop.data.model.Produto;
import Projeto.Petshop.SistemaPetShop.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // Create
    @PostMapping
    public ProdutoDto criarProduto(@RequestBody ProdutoDto produto) {
        return produtoService.criarProduto(produto);
    }

    // Read (Listar todos)
    @GetMapping
    public List<ProdutoDto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Read (Buscar por ID)
    @GetMapping("/{id}")
    public ProdutoDto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    // Update
    @PutMapping("/{id}")
    public ProdutoDto atualizarProduto(@RequestBody ProdutoDto produtoAtualizado) {
        return produtoService.atualizarProduto(produtoAtualizado);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable Long id) {
        if (produtoService.deletarProduto(id)) {
            return "Produto deletado com sucesso";
        } else {
            return "Produto não encontrado";
        }
    }
}
