package in.psk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ECommerceApp03ConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApp03ConfigServerApplication.class, args);
	}

}
