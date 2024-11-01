package Projeto.Petshop.SistemaPetShop.controller;

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
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    // Read (Listar todos)
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    // Read (Buscar por ID)
    @GetMapping("/{id}")
    public Optional<Produto> buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    // Update
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        return produtoService.atualizarProduto(id, produtoAtualizado);
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
