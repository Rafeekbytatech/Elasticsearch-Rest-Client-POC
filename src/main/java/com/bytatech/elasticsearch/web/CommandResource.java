package com.bytatech.elasticsearch.web;

import java.time.LocalDate;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.elasticsearch.service.CommandService;
import com.bytatech.elasticsearch.domain.*;

@RestController
public class CommandResource {

	@Autowired
	CommandService commandService;

	@PostMapping("/createCar")
	public Result createCar(@RequestBody Car c) {

		return commandService.createCar(c);
	}
}
