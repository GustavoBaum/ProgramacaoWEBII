package ProjetoREST.Application.Repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ProjetoREST.Application.Classes.Familia;
import ProjetoREST.Application.Exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;

public interface FamiliaRepositorio extends CrudRepository<Familia, Integer> {

    Optional<Familia> findById(Integer id);

    List<Familia> findAll();

    @Modifying
    @Transactional
    @Query("UPDATE Familia f SET f.name = :name WHERE f.id = :id")
    void updateName(@Param("id") Integer id, @Param("name") String name);

    @Modifying
    @Transactional
    @Query("UPDATE Familia f SET f.description = :description WHERE f.id = :id")
    void updateDescription(@Param("id") Integer id, @Param("description") String description);

    void deleteById(Integer id);

    default Familia findByIdOrThrow(Integer id) {
        return findById(id).orElseThrow(() -> new ResourceNotFoundException("Familia", id));
    }
}