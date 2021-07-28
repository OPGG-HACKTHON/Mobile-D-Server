package opgg.mobiled.joinus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class JoinusApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoinusApplication.class, args);
	}

}
