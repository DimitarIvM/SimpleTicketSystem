package bg.softuni.stssoftuniproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StsSoftuniProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StsSoftuniProjectApplication.class, args);
	}

}
