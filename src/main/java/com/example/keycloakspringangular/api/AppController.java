package com.example.keycloakspringangular.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.keycloakspringangular.model.Hero;

@RestController
@RequestMapping("/api/heroes")
public class AppController {
	
	private List<Hero> heroes = List.of(
			new Hero(1, "Ken"),
			new Hero(2, "Jeroen"),
			new Hero(3, "James"));
	
	@GetMapping
	public List<Hero> heroes() {
		return heroes;
	}
	
	@GetMapping("/{id}")
	public Hero hero(@PathVariable("id") Integer id) {
		return heroes.stream()
				.filter(h -> h.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

}
