package Projeto.Petshop.SitemaPetShop.service;

import Projeto.Petshop.SitemaPetShop.entity.Cliente;
import Projeto.Petshop.SitemaPetShop.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    // Outros métodos de serviço (atualização, busca por ID, etc.)
}

