package com.bytatech.elasticsearch.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import com.bytatech.elasticsearch.domain.Car;
import com.bytatech.elasticsearch.domain.User;
import com.bytatech.elasticsearch.service.QueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class QueryServiceImpl implements QueryService {
	private RestHighLevelClient restHighLevelClient;

    private ObjectMapper objectMapper;

    public QueryServiceImpl( ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
        this.objectMapper = objectMapper;
        this.restHighLevelClient = restHighLevelClient;
    }
	public Car getCar(Long id){
		GetRequest getRequest = new GetRequest(
		        "car", 
		        id.toString()); 
		  GetResponse getResponse = null;
		try {
			getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          Map<String, Object> resultMap = getResponse.getSource();
          return objectMapper.convertValue(resultMap,Car.class);

		
	}
	/* public List<User> readAll() throws IOException {
	        List<User> users = new ArrayList<>();
	        SearchRequest searchRequest = new SearchRequest("users");
	        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
	        searchRequest.source(searchSourceBuilder);
	        searchSourceBuilder.size(5);
	        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
	        for(SearchHit searchHit : searchResponse.getHits().getHits()){
	            User user = new ObjectMapper().readValue(searchHit.getSourceAsString(),User.class);
	            users.add(user);
	        }
	        return users;
	    }*/
}
