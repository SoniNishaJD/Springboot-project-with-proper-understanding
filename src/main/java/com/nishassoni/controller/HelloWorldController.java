package com.nishassoni.controller;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // tells a controller that the object returned is automatically serialized into JSON and passed back into HTTP Responsed object
@RestController // Combination of @Controller and @ResponseBody
public class HelloWorldController {
	
	@GetMapping("/hello-world")
	public String HelloWorld() {
		return "Hello World!";
	}

}
