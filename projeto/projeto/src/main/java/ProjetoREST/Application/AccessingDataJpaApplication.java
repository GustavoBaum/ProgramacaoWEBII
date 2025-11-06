package ProjetoREST.Application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ProjetoREST.Application.Classes.Familia;
import ProjetoREST.Application.Repositorio.FamiliaRepositorio;

@SpringBootApplication
public class AccessingDataJpaApplication {
    
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AccessingDataJpaApplication.class, args);
    }
 
    @Bean
    public CommandLineRunner demo(FamiliaRepositorio familia) {
        return (args) -> {
            familia.save(new Familia("Canidae", "Família dos cães"));
            familia.save(new Familia("Felidae", "Família dos felinos"));
            familia.save(new Familia("Ursidae", "Família dos ursos"));
            familia.save(new Familia("Bovidae", "Família dos bovinos"));
            familia.save(new Familia("Cervidae", "Família dos cervos"));

            log.info("Famílias cadastradas encontradas por findAll():");
            log.info("-----------------------------------------------");
            familia.findAll().forEach(familia1 -> {
                log.info(familia1.toString());
            });
            log.info("");

            log.info("Família encontrada com findById(1):");
            log.info("-----------------------------------");
            log.info(familia.toString());
            log.info("");

            log.info("Família encontrada com findByName('Felidae'):");
            log.info("---------------------------------------------");
            familia.findByName("Felidae").forEach(familia2 -> {
                log.info(familia2.toString());
            });
            log.info("");            
        };
        
    }
    
}
