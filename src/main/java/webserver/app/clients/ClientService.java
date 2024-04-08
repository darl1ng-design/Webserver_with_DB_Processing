package webserver.app.clients;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
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

        if(clientPESEL.isPresent()){
            throw new EntityExistsException("Client already exists in database");
        }
        clientRepository.save(c);
    }

    public void deleteClient(Long clientId){
        boolean exists = clientRepository.existsById(clientId);
            if(!exists){
                throw new EntityNotFoundException("Client with id of " + clientId + " does not exist in database.");
            }
        clientRepository.deleteById(clientId);
    }
@Transactional
    public void updateClient(Long clientId, String last_name, Long pesel){
        Client c = clientRepository.findById(clientId).orElseThrow(
                () -> new EntityNotFoundException(
                        "Client with id of" + clientId + "does not exist"
                ));

        if(last_name != null && !last_name.isEmpty() && !Objects.equals(c.getClient_lname(), last_name)) c.setClient_lname(last_name);

        if(pesel != null && !Objects.equals(c.getPESEL(), pesel)){
            Optional<Client> clientOp = clientRepository.findClientByPESEL(pesel);
                if(clientOp.isPresent()){
                    throw new EntityExistsException("User exists");
                }
            c.setPESEL(pesel);
         }
    }
}
