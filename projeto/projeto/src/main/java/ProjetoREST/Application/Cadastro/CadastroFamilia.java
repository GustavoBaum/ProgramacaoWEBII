package ProjetoREST.Application.Cadastro;

import ProjetoREST.Application.Classes.Familia;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CadastroFamilia {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        //LEITURA
        Familia f1 = em.find(Familia.class, 1);
        System.out.println("Família 1: "+f1.getName());

        //INSERÇÃO
        Familia novo = new Familia("Felinos", "Família dos gatos");
        em.getTransaction().begin();
        em.persist(novo);
        em.getTransaction().commit();
        System.out.println("Inserido família com id: "+novo.getId());

        //ATUALIZAÇÃO
        Familia f2 = em.find(Familia.class, 2);
        em.getTransaction().begin();
        f2.setName("Pantherinae");
        em.getTransaction().commit();

        //REMOÇÃO
        Familia f3 = em.find(Familia.class, novo.getId());
        em.getTransaction().begin();
        em.remove(f3);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}