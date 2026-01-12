package com.example.client_service.services;

import com.example.client_service.entities.Client;
import com.example.client_service.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service pour la gestion des opérations métier liées aux clients
 * Sert de couche intermédiaire entre le contrôleur et le repository
 */
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /**
     * Récupère tous les clients enregistrés
     * @return Liste de tous les clients
     */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    /**
     * Recherche un client par son identifiant
     * @param id Identifiant du client à rechercher
     * @return Le client correspondant à l'identifiant
     * @throws Exception Si aucun client n'est trouvé avec l'identifiant spécifié
     */
    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client non trouvé avec l'ID: " + id));
    }

    /**
     * Enregistre un nouveau client dans la base de données
     * @param client Le client à enregistrer
     * @return Le client enregistré avec son identifiant généré
     */
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
}
