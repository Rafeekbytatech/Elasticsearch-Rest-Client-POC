package com.bytatech.elasticsearch.service.impl;
import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.DocWriteResponse.Result;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bytatech.elasticsearch.service.CommandService;
import com.bytatech.elasticsearch.domain.*;
@Service
public class CommandServiceImpl implements CommandService {

	  private RestHighLevelClient restHighLevelClient;

	    private ObjectMapper objectMapper;

	    public CommandServiceImpl( ObjectMapper objectMapper, RestHighLevelClient restHighLevelClient) {
	        this.objectMapper = objectMapper;
	        this.restHighLevelClient = restHighLevelClient;
	    }

	
	
	  public Result createCar(Car car){
		  IndexResponse response = null;
	        Map<String, Object> dataMap = objectMapper.convertValue(car, Map.class);
	        IndexRequest indexRequest = new IndexRequest("car")
	                .source(dataMap);
	        try {
	            response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
	        } catch(ElasticsearchException e) {
	            e.getDetailedMessage();
	        } catch (java.io.IOException ex){
	            ex.getLocalizedMessage();
	        }
	        return response.getResult();
	    }
	  
	  

	
}
