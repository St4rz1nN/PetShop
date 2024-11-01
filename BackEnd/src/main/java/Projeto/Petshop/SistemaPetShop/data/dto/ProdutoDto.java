package Projeto.Petshop.SistemaPetShop.data.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class ProdutoDto {

    private Long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private String descricao;
}