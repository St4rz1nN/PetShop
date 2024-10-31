package Projeto.Petshop.SistemaPetShop.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;

    public Cliente() {}

    // Exemplo de método que precisa de tipo de retorno
    public Long getId() {
        return id;  // Retorna o id
    }

    public void setId(Long id) {
        this.id = id;  // Não retorna nada, então é void
    }

    public String getNome() {
        return nome;  // Retorna o nome
    }

    public void setNome(String nome) {
        this.nome = nome;  // Não retorna nada, então é void
    }

    // Métodos para email e telefone
}
