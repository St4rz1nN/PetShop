package Projeto.Petshop.SistemaPetShop.exception;

import Projeto.Petshop.SistemaPetShop.data.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(CommonsException.class)
    protected ResponseEntity<MessageDto> handleCommonsException(CommonsException exception) {
        logger.error("[exception] " + exception);
        return exception.getMessageError();
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<MessageDto> handleException(Exception ex) {
        logger.error("Exception não tratada: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageDto("Exception não tratada: ",
                        "petshop.global.handler.exception"));
    }
}
