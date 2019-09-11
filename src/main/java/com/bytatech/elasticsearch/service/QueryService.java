package com.bytatech.elasticsearch.service;
import com.bytatech.elasticsearch.domain.*;

import java.io.IOException;
import java.util.*;

import org.elasticsearch.action.search.SearchResponse;
public interface QueryService {
 public Car getCar(String id);
 public List<Car> findById(Long id);
 public String getCarByColorAggregation() throws IOException;
}
