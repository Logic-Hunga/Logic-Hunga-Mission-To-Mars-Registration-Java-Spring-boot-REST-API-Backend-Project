/**THE API CLASS, HAVING API RESOURCES*/
package com.example.Mission.To.Mars.Registration.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Controller  dependency injection
@RequestMapping(path = "api/v1/client") // path of api

public class ClientController {

    // Reference
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    /**Getting something from the server*/
    //The rest
    @GetMapping
    public List<Client> getClients() { // Getting the client class to String method
          return  clientService.getClients();
    }

    /**POSTING Client (Saving a person into database(Adding new person)*/
    @PostMapping
    public void registerNewClient(@RequestBody Client client) {
        clientService.addNewClient(client);
    }

    /**DELETING  Client (remove a person from database*/
    @DeleteMapping(path = "{clientId}")
    public void deleteClient(@PathVariable("clientId") Long clientId) {
        clientService.deleteClient(clientId);
    }

    /**UPDATING  Client (renaming or change client details a person from database*/
    @PutMapping(path = "{clientId}")
    public void upDateClient(
            @PathVariable("clientId") Long clientId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        clientService.upDateClient(clientId, name, email);
    }

}


