package ProjetoREST.Application.Classes;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nm_familia", nullable = false, length = 100)
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "ds_familia", nullable = false, length = 255)
    private String description;

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(mappedBy = "familia")
    private List<Genero> generos = new ArrayList<>();

    public List<Genero> getGeneros() {
        return this.generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    @Override
    public String toString() {
        return "{" + "Id: " + this.getId() + ", Name: " + this.getName() + ", Description: " + this.getDescription()
                + "}";
    }

    public Familia(Integer id, String name, String description, List<Genero> genero) {
        setId(id);
        setName(name);
        setDescription(description);
        setGeneros(genero);
    }

    public Familia(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public Familia() { }
}
