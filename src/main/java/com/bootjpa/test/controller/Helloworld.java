package com.bootjpa.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Helloworld {

	@RequestMapping("helloworld.do")
	public String helloworld() {
		return "helloworld";
	}
}
