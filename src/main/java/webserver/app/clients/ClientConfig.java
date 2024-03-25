package webserver.app.clients;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class ClientConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository){
        return args -> {
            Client c1 = new Client(
                    "Alex",
                    "Brown",
                    11111111111L,
                    "Beautiful 11A Street",
                    "alexbrown12@gmail.com",
                    "2001-12-03"
            );
            Client c2 = new Client(
                    "Maria",
                    "Tomson",
                    22222222222L,
                    "Angels 3B Street",
                    "mariatomson1992@gmail.com",
                    "1992-11-02"
            );
            clientRepository.saveAll(
                    List.of(
                            c1,c2
                    )
            );
        };
    }
}
