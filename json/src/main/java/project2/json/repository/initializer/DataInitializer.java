package project2.json.repository.initializer;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import project2.json.domain.Customer;
import project2.json.domain.CustomerStatus;
import project2.json.repository.CustomerRepository;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
@Transactional
public class DataInitializer implements CommandLineRunner {

    private CustomerRepository customerRepository;


    @Override
    public void run(String... args) throws Exception {
        List<Customer> customers = Arrays.asList(
                new Customer(942L, "joshua26", CustomerStatus.DORMANT),
                new Customer(973L, "amanda78", CustomerStatus.ACTIVE),
                new Customer(955L, "teresa57", CustomerStatus.ACTIVE),
                new Customer(1014L, "diana53", CustomerStatus.DORMANT),
                new Customer(987L, "jamie64", CustomerStatus.DORMANT),
                new Customer(992L, "duranjoshua", CustomerStatus.DORMANT),
                new Customer(972L, "stephanieharris", CustomerStatus.ACTIVE),
                new Customer(1016L, "elara", CustomerStatus.ACTIVE),
                new Customer(1011L, "richardwoods", CustomerStatus.ACTIVE),
                new Customer(926L, "rwilliams", CustomerStatus.DORMANT),
                new Customer(983L, "ruthwilliams", CustomerStatus.ACTIVE),
                new Customer(909L, "contrerasrita", CustomerStatus.DORMANT),
                new Customer(902L, "hatfieldallen", CustomerStatus.DORMANT),
                new Customer(918L, "ejackson", CustomerStatus.DORMANT),
                new Customer(982L, "aaronleonard", CustomerStatus.DORMANT),
                new Customer(914L, "smithdouglas", CustomerStatus.DORMANT),
                new Customer(927L, "josephevans", CustomerStatus.ACTIVE),
                new Customer(907L, "gordonnicole", CustomerStatus.ACTIVE),
                new Customer(968L, "sarah38", CustomerStatus.ACTIVE),
                new Customer(953L, "michaelpark", CustomerStatus.DORMANT),
                new Customer(1020L, "tina44", CustomerStatus.ACTIVE),
                new Customer(932L, "dpeterson", CustomerStatus.DORMANT),
                new Customer(998L, "jennifer96", CustomerStatus.DORMANT),
                new Customer(1017L, "gguerrero", CustomerStatus.DORMANT),
                new Customer(913L, "shawnmoreno", CustomerStatus.ACTIVE),
                new Customer(901L, "garciamichael", CustomerStatus.DORMANT),
                new Customer(922L, "charleslewis", CustomerStatus.DORMANT),
                new Customer(929L, "ywilliams", CustomerStatus.ACTIVE),
                new Customer(966L, "dlee", CustomerStatus.DORMANT),
                new Customer(938L, "hgross", CustomerStatus.DORMANT)
        );

        customerRepository.saveAll(customers);
    }
}