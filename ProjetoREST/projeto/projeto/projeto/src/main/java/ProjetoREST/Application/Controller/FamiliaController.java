package ProjetoREST.Application.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoREST.Application.Classes.Familia;
import ProjetoREST.Application.Repositorio.FamiliaRepositorio;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {

    @Autowired
    private FamiliaRepositorio familiaRepositorio;

    // GET - Listar todas as famílias
    @GetMapping
    public List<Familia> getAllFamilias() {
        return familiaRepositorio.findAll();
    }

    // GET - Buscar família por ID
    @GetMapping("/{id}")
    public ResponseEntity<Familia> getFamiliaById(@PathVariable Integer id) {
        Optional<Familia> familia = familiaRepositorio.findById(id);
        return familia.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    // POST - Criar nava família
    @PostMapping
    public Familia createFamilia(@RequestBody Familia familia) {
        return familiaRepositorio.save(familia);
    }

    // DELETE - Remover família
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFamilia(@PathVariable Integer id) {
        if (familiaRepositorio.existsById(id)) {
            familiaRepositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}