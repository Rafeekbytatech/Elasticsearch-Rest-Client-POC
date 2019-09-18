package com.bytatech.elasticsearch.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.elasticsearch.service.QueryService;
import com.bytatech.elasticsearch.domain.*;

@RestController
public class QueryResource {

	@Autowired
	QueryService queryService;

	/*@GetMapping("/findByMetaId/{id}")
	public Car getCar(@PathVariable String id) {

		return queryService.getCar(id);
	}
*/
	@GetMapping("/findById/{id}")
	public List<Car> findById(@PathVariable Long id) {
		return queryService.findById(id);
	}

	
	@GetMapping("/colorAggregation")
	public List<ResultBucket> getCarByColorAggregation() throws IOException {
		return queryService.getCarByColorAggregation();
	}
	
	@GetMapping("/findAllStore")
	public List<Store> findAllStore() {
		return queryService.findAllStore();
	}
	@GetMapping("/storeMakeAggregation")
	public List<ResultBucket> getStoreByMakeAggregation() throws IOException {
		return queryService.getStoreByMakeAggregation();
	}
	
	
	
}
