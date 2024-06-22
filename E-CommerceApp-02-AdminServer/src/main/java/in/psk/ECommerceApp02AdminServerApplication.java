package in.psk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ECommerceApp02AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApp02AdminServerApplication.class, args);
	}

}
