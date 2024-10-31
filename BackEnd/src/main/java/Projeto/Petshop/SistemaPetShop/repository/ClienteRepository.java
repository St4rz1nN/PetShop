package Projeto.Petshop.SistemaPetShop.repository;

import Projeto.Petshop.SistemaPetShop.entity.Cliente;
import Projeto.Petshop.SistemaPetShop.service.ClienteService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ClienteRepository {

    public List<Cliente> findAll() {
        return null;
    }

    public Cliente save(Cliente cliente) {
        return null;
    }

    public void deleteById(Long id) {

    }

    public Optional<Cliente> findById(Long id) {
        return null;
    }

    public boolean existsById(Long id) {
        return false;
    }

}
