package com.example.webshopfinalversion;


import com.example.webshopfinalversion.domain.Product;
import com.example.webshopfinalversion.domain.Role;
import com.example.webshopfinalversion.domain.User;
import com.example.webshopfinalversion.repository.ProductRepository;
import com.example.webshopfinalversion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebshopfinalversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebshopfinalversionApplication.class, args);
    }


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;



    @Bean
    public CommandLineRunner setUp(UserRepository userRepository, ProductRepository productRepository) {
        return  (args -> {
            User user1 = new User ("per", "persson", "perssongatan 2","customer", "customer", "per@mail.com", Role.CUSTOMER, 0);
            User user2 = new User ("david","davidsson","Davids väg 11","david", "david", "david@mail.com", Role.CUSTOMER, 0);
            User user3 = new User("Peter","persson","Blåvägen 7","premium", "premium", "peter@mail.com", Role.PREMIUM_CUSTOMER, 500);
            User user4 = new User("Daniel","Bernhardt", "Admingatan 1", "admin", "admin", "admin@mail.com", Role.ADMIN, 0);
            User user5 = new User("dennis", "olsson", "Göteborgsgatan 2", "dennis", "dennis", "dennis@gmail.com", Role.CUSTOMER, 0);

            Product product1 = new Product("Divergent",     "Divergent is a series about a society divided among assigned factions and and a girl who doesn't fit into any of them.", 60.0D);
            Product product2 = new Product("Avatar",     "The film's title refers to a genetically engineered Na'vi body operated from the brain of a remotely located human that is used to interact with the natives of Pandora.", 60.0D);
            Product product3 = new Product("Hobbit",    "Bilbo Baggins, sets out to the Lonely Mountain with a spirited group of dwarves to reclaim their mountain home", 20.0D);
            Product product4 = new Product("Spider man",  "When bitten by a genetically modified spider, a nerdy, shy, and awkward high school student gains spider-like abilities", 100.0D);
            Product product5 = new Product("Jumanji","The story focuses on a group of teenagers who come across Jumanji—now transformed into a video game", 10.0D);
            Product product6 = new Product("Batman",     "Batman's foremost qualities include wealth, physical strength, intelligence, and obsessive passion.", 30.0D);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);
            productRepository.save(product6);
        });
    }
}
