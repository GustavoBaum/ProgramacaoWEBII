package ProjetoREST.Application.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ProjetoREST.Application.Classes.Familia;
import ProjetoREST.Application.Classes.Genero;

public interface GeneroRepositorio extends CrudRepository<Genero, Integer>{
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    Optional findById(Integer id);

    Genero findByName(Integer name);

    List<Genero> findAll();

    List<Genero> findBySubFamilia(Familia subFamilia);

    Genero updateName(Integer id, String name);

    Genero updateDescription(Integer id, String description);

    void deleteById(Integer id);
}
