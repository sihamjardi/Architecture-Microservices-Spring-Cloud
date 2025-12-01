package com.example.service_voiture.services;

import com.example.service_voiture.entities.Client;
import com.example.service_voiture.entities.Voiture;
import com.example.service_voiture.feign.ClientService;
import com.example.service_voiture.repositories.VoitureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class VoitureService {

    private final VoitureRepository voitureRepository;
    private final ClientService clientService;

    public List<Voiture> getVoituresAvecClients() {
        List<Voiture> voitures = voitureRepository.findAll();
        voitures.forEach(v -> {
            Client client = clientService.clientById(v.getClientId());
            v.setClient(client);
        });
        return voitures;
    }

    public Voiture getVoitureAvecClient(Long id) {
        Voiture voiture = voitureRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Voiture introuvable"));

        Client client = clientService.clientById(voiture.getClientId());
        voiture.setClient(client);

        return voiture;
    }

    public List<Voiture> getVoituresCliente(Long clientId){
        return voitureRepository.findByClientId(clientId);
    }

    public Voiture saveVoiture(Voiture voiture){
        return voitureRepository.save(voiture);
    }

    public void deleteVoiture(Long id){
        voitureRepository.deleteById(id);
    }
}
