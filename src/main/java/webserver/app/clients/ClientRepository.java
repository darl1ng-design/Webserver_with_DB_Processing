package webserver.app.clients;

        // DATA ACCESS LAYER //


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
        @Query("SELECT c from Client c where c.PESEL =?1")
        Optional<Client> findClientByPESEL(Long pesel);

}
