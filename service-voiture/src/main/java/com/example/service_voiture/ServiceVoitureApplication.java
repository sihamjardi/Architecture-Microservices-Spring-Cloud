package com.example.service_voiture;


import com.example.service_voiture.repositories.VoitureRepository;
import com.example.service_voiture.feign.ClientService;
import com.example.service_voiture.entities.Client;
import com.example.service_voiture.entities.Voiture;
import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@EnableFeignClients
@SpringBootApplication
public class ServiceVoitureApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceVoitureApplication.class, args);
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(1000, 5000, 5); // attente initiale 1s, max 5s, max 5 tentatives
    }

    @Bean
    CommandLineRunner initialiserBaseH2(VoitureRepository voitureRepository, ClientService clientService){
        return args -> {
            Thread.sleep(5000);
            Client c1 = null;
            Client c2 = null;

            try {
                c1 = clientService.clientById(2L);
                c2 = clientService.clientById(1L);
            } catch (Exception e) {
                System.out.println("Impossible de récupérer les clients depuis SERVICE-CLIENT. Vérifiez que le service est démarré.");
                return; // Arrêter l'initialisation des voitures si clients non disponibles
            }

            System.out.println("**************************");
            System.out.println("Id est :" + c2.getId());
            System.out.println("Nom est :" + c2.getNom());
            System.out.println("**************************");
            System.out.println("Id est :" + c1.getId());
            System.out.println("Nom est :" + c1.getNom());
            System.out.println("Age est :" + c1.getAge());
            System.out.println("**************************");

            voitureRepository.save(new Voiture(null, "Toyota", "A 25 333", "Corolla", 1L, c2));
            voitureRepository.save(new Voiture(null, "Renault", "B 6 3456", "Megane", 1L, c2));
            voitureRepository.save(new Voiture(null, "Peugeot", "A 55 4444", "301", 2L, c1));
        };
    }


}