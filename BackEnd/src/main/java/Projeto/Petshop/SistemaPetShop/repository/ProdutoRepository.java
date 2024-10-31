package Projeto.Petshop.SistemaPetShop.repository;

import Projeto.Petshop.SistemaPetShop.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
