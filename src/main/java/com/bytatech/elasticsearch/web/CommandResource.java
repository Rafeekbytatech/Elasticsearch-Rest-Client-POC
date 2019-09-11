package com.bytatech.elasticsearch.web;

import java.time.LocalDate;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.elasticsearch.service.CommandService;
import  com.bytatech.elasticsearch.domain.*;
@RestController
public class CommandResource {

	@Autowired
	CommandService commandService;
	@PostMapping("/createCar")
public	Result createCar(Car c){
		/*Car c= new Car();
		c.setId(12l);
		c.setColor("blue");
		c.setMake("ford");
		c.setDate(LocalDate.now());*/
		
	return	commandService.createCar(c);
	}
}
