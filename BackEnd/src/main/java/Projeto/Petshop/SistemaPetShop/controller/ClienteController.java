package Projeto.Petshop.SistemaPetShop.controller;


import Projeto.Petshop.SistemaPetShop.entity.Cliente;
import Projeto.Petshop.SistemaPetShop.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Create
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    // Read (Listar todos)
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    // Read (Buscar por ID)
    @GetMapping("/{id}")
    public Optional<Cliente> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    // Update
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente clienteAtualizado) {
        return clienteService.atualizarCliente(id, clienteAtualizado);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id) {
        if (clienteService.deletarCliente(id)) {
            return "Cliente deletado com sucesso";
        } else {
            return "Cliente não encontrado";
        }
    }
}

