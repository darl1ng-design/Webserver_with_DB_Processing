package webserver.app.clients;


// api endpoint/routes logic //

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/clients")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @PostMapping
    public void AddClient(@RequestBody Client client){
        clientService.AddClient(client);
    }

    @DeleteMapping(path="{clientId}")
    public void DeleteClient(@PathVariable("clientId") Long clientId){
        clientService.deleteClient(clientId);
    }

    @PutMapping(path="{clientId}")
    public void UpdateClient(@PathVariable("clientId") Long clientId, String lname, Long pesel){
        clientService.updateClient(clientId, lname, pesel);
    }
}
