package Projeto.Petshop.SistemaPetShop.data.model;

import jakarta.persistence.*;
import lombok.Data;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Entity
@Table(name="produtos")
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Double preco;
    private Integer quantidade;
    private String descricao;
}

