package Projeto.Petshop.SistemaPetShop.exception;

import Projeto.Petshop.SistemaPetShop.data.dto.MessageDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class CommonsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -4694258578216919456L;

    protected HttpStatus status;
    protected String key;
    protected String text;

    public ResponseEntity<MessageDto> getMessageError() {
        return ResponseEntity.status(status).body(new MessageDto(text, key));
    }
}