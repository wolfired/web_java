package com.wolfired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WebJavaApplication {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String Home(@RequestParam Long id) {
		var op = userRepository.findById(id);
		if (op.isEmpty()) {
			return "null";
		}
		return op.get().getName();
	}

	@GetMapping("/add_user")
	public String AddUser(@RequestParam String name) {
		User u = new User();
		u.setName(name);
		userRepository.save(u);

		StringBuilder sb = new StringBuilder();
		
		for (User uu : userRepository.findAll()) {
			sb.append(uu.getId()).append(": ").append(uu.getName());
			sb.append("<br/>");
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(WebJavaApplication.class, args);
	}

}
