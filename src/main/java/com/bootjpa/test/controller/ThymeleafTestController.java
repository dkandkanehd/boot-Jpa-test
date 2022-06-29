package com.bootjpa.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bootjpa.test.vo.TestVo;

@Controller
public class ThymeleafTestController {

	@GetMapping("thymeleafTest")
	public String thymeleafTest(Model model) {
		TestVo testModel = new TestVo("testId", "testName") ;
	    model.addAttribute("testModel", testModel);
		
		return "thymeleaf/thymeleafTest";
	}
}
