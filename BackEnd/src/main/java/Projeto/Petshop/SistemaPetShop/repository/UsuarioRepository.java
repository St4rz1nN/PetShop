package Projeto.Petshop.SistemaPetShop.repository;

import Projeto.Petshop.SistemaPetShop.data.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
