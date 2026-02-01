package com.src.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@GetMapping("/hello")
	public ResponseEntity<String> home()
	{
		return ResponseEntity.ok().body("Hello World!! Home page!!");
	}
	
	@GetMapping("/hi")
	public ResponseEntity<String> hi()
	{
		return ResponseEntity.ok().body("Hii this is new API response");
	}

}
