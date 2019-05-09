package com.horppe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloWorldController {
	
	@RequestMapping("/")
	@ResponseBody
	public String index() {
		// TODO Auto-generated constructor stub
		return "Hello World";
	}

}
