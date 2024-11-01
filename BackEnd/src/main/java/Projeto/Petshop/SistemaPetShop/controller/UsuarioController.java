package Projeto.Petshop.SistemaPetShop.controller;


import Projeto.Petshop.SistemaPetShop.data.dto.UsuarioDto;
import Projeto.Petshop.SistemaPetShop.data.model.Usuario;
import Projeto.Petshop.SistemaPetShop.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class UsuarioController {

    @Autowired
    private UsuarioService clienteService;

    // Create
    @PostMapping
    public UsuarioDto criarCliente(@RequestBody UsuarioDto usuario) {
        return clienteService.criarUsuario(usuario);
    }

    // Read (Listar todos)
    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return clienteService.listarUsuarios();
    }

    // Read (Buscar por ID)
    @GetMapping("/{id}")
    public UsuarioDto buscarUsuarioPorId(@PathVariable Long id) {
        return clienteService.buscarUsuarioPorId(id);
    }

    // Update
    @PutMapping("/{id}")
    public UsuarioDto atualizarUsuario(@RequestBody UsuarioDto clienteAtualizado) {
        return clienteService.atualizarUsuario(clienteAtualizado);
    }

    // Delete
    @DeleteMapping("/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        if (clienteService.deletarCliente(id)) {
            return "Cliente deletado com sucesso";
        } else {
            return "Cliente não encontrado";
        }
    }
}

