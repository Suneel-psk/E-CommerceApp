package in.psk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ECommerceApp01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceApp01EurekaServerApplication.class, args);
	}

}
