package webserver.app.clients;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

    //logic for API methods on client Table
@Service
public class ClientService {
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    public List<Client> getClients(){
        return clientRepository.findAll();
    }

    public void AddClient(Client c){
        Optional<Client> clientPESEL = clientRepository.findClientByPESEL(c.getPESEL());
        Optional<Client> clientEmail = clientRepository.findClientByEmail(c.getEmail());

        if(clientPESEL.isPresent() || clientEmail.isPresent()){
            throw new IllegalStateException("Client already exists in database");
        }
        clientRepository.save(c);
    }

    public void deleteClient(Long clientId){
        boolean exists = clientRepository.existsById(clientId);
            if(!exists){
                throw new IllegalStateException("Client with id of " + clientId + " does not exist in database.");
            }
        clientRepository.deleteById(clientId);
    }
@Transactional
    public void updateClient(Long clientId, String lname, String email){
        Client c = clientRepository.findById(clientId).orElseThrow(
                () -> new IllegalStateException(
                        "Client with id of" + clientId + "does not exist"
                ));

        if(lname != null && !lname.isBlank() && !Objects.equals(c.getClient_lname(), lname)){
            c.setClient_lname(lname);
        }

        if(email != null && !email.isBlank() && !Objects.equals(c.getEmail(), email)){
            Optional<Client> clientOp = clientRepository.findClientByEmail(email);
                if(clientOp.isPresent()){
                    throw new IllegalStateException("E-mail is taken");
                }
            c.setEmail(email);
         }
    }
}
