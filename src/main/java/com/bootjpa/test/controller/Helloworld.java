package com.bootjpa.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Helloworld {

	@GetMapping("helloworld")
	public String helloworld() {
		return "helloworld";
	}
}
