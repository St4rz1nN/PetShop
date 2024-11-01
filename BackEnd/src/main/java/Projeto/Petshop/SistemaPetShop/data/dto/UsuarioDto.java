package Projeto.Petshop.SistemaPetShop.data.dto;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UsuarioDto {
    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
