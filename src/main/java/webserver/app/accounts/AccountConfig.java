package webserver.app.accounts;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AccountConfig {
    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            Account a1 = new Account(
                    "alexb123",
                    "cLDO@(#NMDK!12",
                    "alexb123@gmail.com",
                    "personal account",
                    "2012-04-20",
                    "2017-09-28"
            );
            Account a2 = new Account(
                    "martom918243",
                    "jdJH@Kdjl1j",
                    "mart234@hotmail.com",
                    "savings account",
                    "2019-08-14",
                    "2023-01-23"
            );
            Account a3 = new Account(
                    "dfloyd7163",
                    "MND1$#@jfk@",
                    "floydD28441@gmail.com",
                    "foreign currency account",
                    "2009-12-30",
                    "2015-05-18"
            );
            accountRepository.saveAll(
                    List.of(
                            a1, a2, a3
                    )
            );
        };
    }
}
