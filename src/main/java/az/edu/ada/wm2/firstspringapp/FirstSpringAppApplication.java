package az.edu.ada.wm2.firstspringapp;

import az.edu.ada.wm2.firstspringapp.model.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController // "/"
public class FirstSpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSpringAppApplication.class, args);
	}

	@GetMapping("/")
	public String greetUser(){
		return "Hello World!";
	}

	public List<String> getPeople(){
		return List.of("Ali", "Musa", "Ilkin");
	}

	@GetMapping("/personObject")
	public List<Person> getPersonObject(){
		return List.of(
				new Person("Musa", "Afandiyev"),
				new Person("Zumrud", "Isgandarli"),
				new Person("Fidan", "Yusifova")
		);
	}

}

