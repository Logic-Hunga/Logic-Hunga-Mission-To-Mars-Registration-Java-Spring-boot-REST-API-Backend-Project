/**THE BUSINESS LOGIC CLASS(SERVICE)*/
package com.example.Mission.To.Mars.Registration.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service // service dependency injection
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public void addNewClient(Client client) {
       Optional<Client> clientOptional=  clientRepository
               .findClientByEmail(client.getEmail());

       if (clientOptional.isPresent()) {
           throw new IllegalStateException("Email taken");
       }
       clientRepository.save(client);
    }

    public void deleteClient(Long clientId) {
        boolean exists =  clientRepository.existsById(clientId);
        if(!exists) {
            throw new IllegalStateException(
                    "Client with ID " + clientId + " does not exists");
        }
        clientRepository.deleteById(clientId);




    }


    @Transient
    public void upDateClient(Long clientId,
                             String name,
                             String email) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException("Client with ID " + clientId + " does not exists"));

        if (name != null &&
               name.length() > 0 &&
               !Objects.equals(client.getName(), name)) {
            client.setName(name);
        }


        if (email != null &&
                  email.length() > 0 &&
                  !Objects.equals(client.getEmail(), email)) {
          Optional<Client> clientOptional = clientRepository
                  .findClientByEmail(email);


          if (clientOptional.isPresent()) {
              throw new IllegalStateException("Email taken");
          }
          client.setEmail(email);
        }
    }
}
