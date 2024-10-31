package Projeto.Petshop.SistemaPetShop.controller;


import Projeto.Petshop.SistemaPetShop.data.model.Usuario;
import Projeto.Petshop.SistemaPetShop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class UsuarioController {

    @Autowired
    private UsuarioService clienteService;

    // Create
    @PostMapping
    public Usuario criarCliente(@RequestBody Usuario cliente) {
        return clienteService.criarCliente(cliente);
    }

    // Read (Listar todos)
    @GetMapping
    public List<Usuario> listarClientes() {
        return clienteService.listarClientes();
    }

    // Read (Buscar por ID)
    @GetMapping("/{id}")
    public Optional<Usuario> buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id);
    }

    // Update
    @PutMapping("/{id}")
    public Usuario atualizarCliente(@PathVariable Long id, @RequestBody Usuario clienteAtualizado) {
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

