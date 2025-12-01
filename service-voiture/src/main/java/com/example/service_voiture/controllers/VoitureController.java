package com.example.service_voiture.controllers;


import com.example.service_voiture.entities.Voiture;
import com.example.service_voiture.services.VoitureService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voitures")
@RequiredArgsConstructor
public class VoitureController {

    private final VoitureService voitureService;


    @GetMapping
    public List<Voiture> getAllVoitures() {
        return voitureService.getVoituresAvecClients();
    }


    @GetMapping("/{id}")
    public Voiture getVoitureById(@PathVariable Long id) {
        return voitureService.getVoitureAvecClient(id);
    }


    @GetMapping("/client/{clientId}")
    public List<Voiture> getVoituresByClient(@PathVariable Long clientId) {
        return voitureService.getVoituresCliente(clientId);
    }

    @PostMapping
    public Voiture addVoiture(@RequestBody Voiture voiture) {
        return voitureService.saveVoiture(voiture);
    }

    @DeleteMapping("/{id}")
    public void deleteVoiture(@PathVariable Long id) {
        voitureService.deleteVoiture(id);
    }
}
