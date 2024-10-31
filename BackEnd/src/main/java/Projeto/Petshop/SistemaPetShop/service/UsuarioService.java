package Projeto.Petshop.SistemaPetShop.service;

import Projeto.Petshop.SistemaPetShop.data.model.Usuario;
import Projeto.Petshop.SistemaPetShop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository clienteRepository;

    // Create
    public Usuario criarCliente(Usuario cliente) {
        return clienteRepository.save(cliente);
    }

    // Read (Listar todos)
    public List<Usuario> listarClientes() {
        return clienteRepository.findAll();
    }

    // Read (Buscar por ID)
    public Optional<Usuario> buscarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    // Update
    public Usuario atualizarCliente(Long id, Usuario clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null;
    }

    // Delete
    public boolean deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

