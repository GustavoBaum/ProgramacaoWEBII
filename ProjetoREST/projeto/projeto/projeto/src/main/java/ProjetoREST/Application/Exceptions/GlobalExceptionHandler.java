package ProjetoREST.Application.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(ResourceNotFoundException.class)
        public ResponseEntity<ErrorResponse> handleResourceNotFound(
                        ResourceNotFoundException ex, WebRequest request) {

                ErrorResponse errorResponse = new ErrorResponse(
                                HttpStatus.NOT_FOUND.value(),
                                new Date(),
                                ex.getMessage(),
                                "Recurso não encontrado",
                                request.getDescription(false).replace("uri=", ""));
                return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<ErrorResponse> handleIllegalArgument(
                        IllegalArgumentException ex, WebRequest request) {

                ErrorResponse errorResponse = new ErrorResponse(
                                HttpStatus.BAD_REQUEST.value(),
                                new Date(),
                                "Parâmetros inválidos",
                                ex.getMessage(),
                                request.getDescription(false).replace("uri=", ""));
                return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorResponse> handleAllExceptions(
                        Exception ex, WebRequest request) {

                ErrorResponse errorResponse = new ErrorResponse(
                                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                new Date(),
                                "Erro interno do servidor",
                                ex.getMessage(),
                                request.getDescription(false).replace("uri=", ""));
                return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
}
