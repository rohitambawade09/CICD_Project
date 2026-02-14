package com.src.controller;

import java.util.HashMap;
import java.util.Map;

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
	
	@GetMapping("/newAPI")
	public ResponseEntity<Map<String, Object>> newFunction()
	{
		Map<String, Object> map = new HashMap<>();
		
		map.put("response", "New code deployed for the pipeline project");
		
		return ResponseEntity.ok().body(map);
	}

}
