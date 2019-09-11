package com.bytatech.elasticsearch.service;

import org.elasticsearch.action.DocWriteResponse.Result;

import com.bytatech.elasticsearch.domain.Car;

public interface CommandService {
	 public Result createCar(Car car);
}
