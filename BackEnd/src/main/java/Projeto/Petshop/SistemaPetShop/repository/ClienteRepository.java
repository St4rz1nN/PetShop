package Projeto.Petshop.SistemaPetShop.repository;

import Projeto.Petshop.SistemaPetShop.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
