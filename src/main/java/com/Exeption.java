package com;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exeption {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        // Obtener detalles sobre la excepción
        String mensajeError = e.getMessage(); // Obtener el mensaje de la excepción
        String tipoError = e.getClass().getSimpleName(); // Obtener el tipo de excepción

        // Crear un mensaje de error personalizado con detalles sobre la excepción
        String mensajePersonalizado = "Se produjo un error de tipo " + tipoError + ": " + mensajeError;

        // Devolver una respuesta con el mensaje de error personalizado y el código de estado 500 (Internal Server Error)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mensajePersonalizado);
    }
    
}
