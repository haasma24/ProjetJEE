package tn.pi.test.Service;

import tn.pi.test.Entity.Client;

import java.util.List;
import java.util.Optional;

public interface iClientService  {
    Client createClient(Client client);

    Optional<Client> getClientById(Long id);

    List<Client> getAllClients();

    Client updateClient(Long id, Client clientDetails);

    void deleteClient(Long id);
}
