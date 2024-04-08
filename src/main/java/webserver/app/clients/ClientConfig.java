package webserver.app.clients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner clrClient(ClientRepository clientRepository){
        return args -> {
            Client c1 = new Client(
                    "Alex",
                    "Brown",
                    11111111111L,
                    "Beautiful 11A Street",
                    "2001-12-03"
            );
            Client c2 = new Client(
                    "Maria",
                    "Tomson",
                    22222222222L,
                    "Angels 3B Street",
                    "1992-11-02"
            );
            Client c3 = new Client(
                    "Damian",
                    "Floyd",
                    33333333333L,
                    "Hashbrown 3F Street",
                    "1985-01-09"
            );
            clientRepository.saveAll(
                    List.of(
                            c1,c2, c3
                    )
            );
        };
    }
}
