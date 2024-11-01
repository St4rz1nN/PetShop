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
    public UsuarioDto criarUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo");
        }
        Usuario usuario = DozerConverter.parseObject(usuarioDto, Usuario.class);
        usuario = usuarioRepository.save(usuario);
        return DozerConverter.parseObject(usuario, UsuarioDto.class);
    }

    // Read (Listar todos)
    public List<UsuarioDto> listarUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return DozerConverter.parseListObjects(usuarios, UsuarioDto.class);
    }

    // Read (Buscar por ID)
    public UsuarioDto buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        return usuarioOpt.map(usuario -> DozerConverter.parseObject(usuario, UsuarioDto.class)).orElse(null);
    }

    // Update
    public UsuarioDto atualizarUsuario(UsuarioDto usuarioDto) {
        if (usuarioDto == null || usuarioDto.getId() == null) {
            throw new IllegalArgumentException("Usuário ou ID não podem ser nulos");
        }
        if (usuarioRepository.existsById(usuarioDto.getId())) {
            Usuario usuario = DozerConverter.parseObject(usuarioDto, Usuario.class);
            usuario = usuarioRepository.save(usuario);
            return DozerConverter.parseObject(usuario, UsuarioDto.class);
        }
        return null;
    }

    // Delete
    public boolean deletarUsuario(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}