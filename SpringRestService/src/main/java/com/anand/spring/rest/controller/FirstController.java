package com.anand.spring.rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.anand.spring.rest.bean.Greetings;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/first")
public class FirstController {
	
	protected Logger logger = LoggerFactory.getLogger(FirstController.class);
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public @ResponseBody String getReadMethod(@RequestParam("data") String input)
	{
		String returnValue = null;
		ObjectMapper mapper = new ObjectMapper();
		Greetings greetings = new Greetings();
		logger.info("Input: "+input);
		try 
		{
			greetings.setGreeting("Hello ");
			greetings.setName(input);
			
			returnValue = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(greetings);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return returnValue;
	}

}
