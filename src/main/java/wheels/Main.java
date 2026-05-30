package wheels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Este comando liga o servidor Tomcat embutido e inicializa o Spring Boot e o SQLite
        SpringApplication.run(Main.class, args);
    }
}


// http://localhost:8080/bicicletas