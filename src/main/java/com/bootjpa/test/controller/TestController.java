package com.bootjpa.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bootjpa.test.service.TestService;
import com.bootjpa.test.vo.TestVo;

@Controller
public class TestController {
	@Autowired
	TestService testService;

	@RequestMapping(value = "/test")
	public ModelAndView test() throws Exception{
	    ModelAndView mav = new ModelAndView("test/test");

	    List<TestVo> testList = testService.selectTest();
	    mav.addObject("list", testList);
		
	    return mav;
	}
}
