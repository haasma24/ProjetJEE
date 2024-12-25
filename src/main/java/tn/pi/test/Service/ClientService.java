package tn.pi.test.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.pi.test.Entity.Client;
import tn.pi.test.Repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements iClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        existingClient.setNom(clientDetails.getNom());
        existingClient.setPrenom(clientDetails.getPrenom());
        existingClient.setEmail(clientDetails.getEmail());
        existingClient.setTelephone(clientDetails.getTelephone());
        return clientRepository.save(existingClient);
    }

    public void deleteClient(Long id) {
        Client existingClient = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client non trouvé"));
        clientRepository.delete(existingClient);
    }
}
