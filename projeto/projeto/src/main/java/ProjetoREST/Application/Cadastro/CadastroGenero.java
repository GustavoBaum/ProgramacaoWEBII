package ProjetoREST.Application.Cadastro;

import ProjetoREST.Application.Classes.Genero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CadastroGenero {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        //LEITURA
        Genero g1 = em.find(Genero.class, 1);
        System.out.println("Genero 1: " + g1.getName());

        //INSERÇÃO
        Genero novo = new Genero();
        novo.setName("Genero Nvo");
        em.getTransaction().begin();
        em.persist(novo);
        em.getTransaction().commit();
        System.out.println("Inserido genero com id: " + novo.getId());

        //ATUALIZAÇÃO
        Genero g2 = em.find(Genero.class, novo.getId());
        em.getTransaction().begin();
        g2.setName("Novo nome de genero");
        em.getTransaction().commit();

        //REMOÇÃO
        Genero g3 = em.find(Genero.class, novo.getId());
        em.getTransaction().begin();
        em.remove(g3);
        em.getTransaction().commit();
        em.close();
        emf.close();     
        
    }
    
}
