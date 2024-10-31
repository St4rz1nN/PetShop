package Projeto.Petshop.SistemaPetShop.repository;

import Projeto.Petshop.SistemaPetShop.data.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
