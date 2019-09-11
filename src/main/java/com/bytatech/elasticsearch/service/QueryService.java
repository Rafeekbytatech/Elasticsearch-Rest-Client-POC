package com.bytatech.elasticsearch.service;
import com.bytatech.elasticsearch.domain.*;
import java.util.*;
public interface QueryService {
 public Car getCar(String id);
 public List<Car> findById(Long id);
}
