package ProjetoREST.Application.Exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ResourceNotFoundException(String resourceName, Integer id) {
        super(String.format("%s não encontrado com id: %d", resourceName, id));
    }

    public ResourceNotFoundException(String resourceName, String criterio) {
        super(String.format("%s não encontrado com critérios: $s", resourceName, criterio));
    }
}   
