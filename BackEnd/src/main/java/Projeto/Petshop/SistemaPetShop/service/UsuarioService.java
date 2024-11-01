package Projeto.Petshop.SistemaPetShop.service;

import Projeto.Petshop.SistemaPetShop.data.dto.UsuarioDto;
import Projeto.Petshop.SistemaPetShop.data.model.Usuario;
import Projeto.Petshop.SistemaPetShop.dozer.DozerConverter;
import Projeto.Petshop.SistemaPetShop.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Create
    public UsuarioDto criarUsuario(UsuarioDto usuario) {
        usuarioRepository.save(DozerConverter.parseObject(usuario, Usuario.class));
        return usuario;
    }

    // Read (Listar todos)
    public List<UsuarioDto> listarUsuarios() {
        return DozerConverter.parseListObjects(usuarioRepository.findAll(), UsuarioDto.class);
    }

    // Read (Buscar por ID)
    public UsuarioDto buscarUsuarioPorId(Long id) {
        return DozerConverter.parseObject(usuarioRepository.findById(id), UsuarioDto.class);
    }

    public UsuarioDto atualizarUsuario(UsuarioDto usuario) {
        if (usuarioRepository.existsById(usuario.getId())) {
            usuarioRepository.save(DozerConverter.parseObject(usuario, Usuario.class));
            return usuario;
        }
        return null;
    }

    // Delete
    public boolean deletarCliente(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}