package ProjetoREST.Application.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "generos")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "id_familia", nullable = false)
    private Familia familia;

    public Genero() {
        setId(id);
        setName(name);
        setFamilia(familia);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void seDescription(String description) {
        this.description = description;
    }

    public Familia getFamilia() {
        return this.familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }
}