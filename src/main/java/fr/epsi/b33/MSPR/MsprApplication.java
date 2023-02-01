package fr.epsi.b33.MSPR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MsprApplication {

	@GetMapping("/")
	public String main(){
		return "Hello world";
	}

	public static void main(String[] args) {
		SpringApplication.run(MsprApplication.class, args);
	}

}
