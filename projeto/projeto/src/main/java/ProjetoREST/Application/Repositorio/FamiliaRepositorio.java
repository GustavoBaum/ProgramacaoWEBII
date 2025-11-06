package ProjetoREST.Application.Repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ProjetoREST.Application.Classes.Familia;
import ProjetoREST.Application.Classes.Genero;

public interface FamiliaRepositorio extends CrudRepository<Familia, Integer> {
    
    Familia createNewFamilia(Familia familia);

    Genero createNewGenero(Genero genero);
    
    Familia findById(long id);

    List<Familia> findByName(String name);
    
    List<Familia> findAll();

    Familia updateName(Integer id, String name);

    Familia updateDescription(Integer id, String description);

    void deleteById(Integer id);

}