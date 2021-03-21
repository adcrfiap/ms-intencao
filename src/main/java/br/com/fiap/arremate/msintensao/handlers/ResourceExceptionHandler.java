package br.com.fiap.arremate.msintensao.handlers;


import br.com.fiap.arremate.msintensao.exceptions.DetalhesErro;
import br.com.fiap.arremate.msintensao.exceptions.ExceptionErros;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ExceptionErros.class)
    public ResponseEntity<DetalhesErro> handlerExceptionErrosException(ExceptionErros e,
                                                                                 HttpServletRequest request){
        DetalhesErro erro = new DetalhesErro(e.getMessage(), 404L);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
}
