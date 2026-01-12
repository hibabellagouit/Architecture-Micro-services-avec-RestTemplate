package com.tp.microservicesresttemplateservicevoiture.controllers;

import com.tp.microservicesresttemplateservicevoiture.models.CarResponse;
import com.tp.microservicesresttemplateservicevoiture.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des véhicules
 * Expose les endpoints pour consulter les véhicules et leurs détails
 */
@RestController
@RequestMapping("api/car")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * Récupère la liste complète des véhicules avec les détails des propriétaires
     * @return Liste des véhicules avec les informations des clients associés
     */
    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    /**
     * Récupère les détails d'un véhicule spécifique avec les informations de son propriétaire
     * @param id Identifiant unique du véhicule
     * @return Réponse contenant les détails du véhicule et du client associé
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            CarResponse car = carService.findById(id);
            return ResponseEntity.ok(car);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erreur: " + e.getMessage());
        }
    }
}