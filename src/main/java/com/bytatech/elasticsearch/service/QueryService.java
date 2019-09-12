package com.bytatech.elasticsearch.service;
import com.bytatech.elasticsearch.domain.*;

import java.io.IOException;
import java.util.*;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
public interface QueryService {
 public Car getCar(String id);
 public List<Car> findById(Long id);
 public Bucket getCarByColorAggregation() throws IOException;
}
