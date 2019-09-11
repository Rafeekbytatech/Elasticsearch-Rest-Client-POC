package com.bytatech.elasticsearch.web;

import java.time.LocalDate;
import java.util.List;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.elasticsearch.service.QueryService;
import  com.bytatech.elasticsearch.domain.*;
@RestController
public class QueryResource {

	@Autowired
	QueryService queryService;
	@GetMapping("/getCar/{id}")
public	Car getCar(@PathVariable String id ){
		
		
	return	queryService.getCar(id);
	}
	@GetMapping("/getCars/{id}")
	public List<Car> findById(@PathVariable Long id){
		return	queryService.findById(id);
	}
	
	
}
