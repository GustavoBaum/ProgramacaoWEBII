package ProjetoREST.Application.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoREST.Application.Classes.Genero;
import ProjetoREST.Application.Repositorio.GeneroRepositorio;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroRepositorio generoRepositorio;

    @GetMapping
    public ResponseEntity<List<Genero>> getAllGeneros() {
        try {
            List<Genero> generos = generoRepositorio.findAll();
            return new ResponseEntity<>(generos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable("id") Integer id) {
        Optional<Genero> generoData = generoRepositorio.findById(id);
        return (ResponseEntity<Genero>) generoData.map(genero -> new ResponseEntity<>(genero, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Genero> createGenero(@RequestBody Genero genero) {
        try {
            Genero _genero = generoRepositorio.save(genero);
            return new ResponseEntity<>(_genero, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGenero(@PathVariable("id") Integer id) {
        try {
            if (generoRepositorio.existsById(id)) {
                generoRepositorio.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR

            );
        }
    }
}
