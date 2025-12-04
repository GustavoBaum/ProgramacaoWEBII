package ProjetoREST.Application.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ProjetoREST.Application.Classes.Genero;
import jakarta.transaction.Transactional;

public interface GeneroRepositorio extends CrudRepository<Genero, Integer>{
    
    Optional<Genero> findById(Integer id);

    List<Genero> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Genero g SET g.name = :name WHERE g.id = :id")
    void updateName(@Param("id") Integer id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Genero g SET g.description = :description WHERE g.id = :id")
    void updateDescription(@Param("id") Integer id, @Param("description") String description);

    void deleteById(Integer id);
}
