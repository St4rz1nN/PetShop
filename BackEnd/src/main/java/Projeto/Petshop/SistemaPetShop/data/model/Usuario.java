package Projeto.Petshop.SistemaPetShop.data.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

}
