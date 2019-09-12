package com.bytatech.elasticsearch.service.impl;
import static org.elasticsearch.index.query.QueryBuilders.*;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;*/
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
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms.Bucket;
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
	public Car getCar(String id){
		GetRequest getRequest = new GetRequest(
		        "car", 
		        id); 
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
	public List<Car> findById(Long id) {
	        List<User> users = new ArrayList<>();
	        SearchRequest searchRequest = new SearchRequest("car");
	        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
	        searchSourceBuilder.query(termQuery("id", id));
	        searchRequest.source(searchSourceBuilder);
	        
	        SearchResponse searchResponse=null;
			try {
				searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return  getSearchResult(searchResponse);
	
	        
	    }
	
	  private List<Car> getSearchResult(SearchResponse response) {

	        SearchHit[] searchHit = response.getHits().getHits();

	        List<Car> carList = new ArrayList<>();

	        for (SearchHit hit : searchHit){
	            carList
	                    .add(objectMapper
	                            .convertValue(hit
	                                    .getSourceAsMap(), Car.class));
	        }

	        return carList;
	    }
	
	
	  @Override
		public List<? extends Bucket> getCarByColorAggregation() throws IOException {
			List<String> carList = new ArrayList<String>();
			 SearchRequest searchRequest = new SearchRequest("car");
		        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
		        searchSourceBuilder.query(matchAllQuery());
		        searchSourceBuilder.aggregation(AggregationBuilders.terms("colors").field("color.keyword"));
		       
		        searchRequest.source(searchSourceBuilder);
		        SearchResponse   searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
		        System.out.println("elasticsearch response: {} totalhitssshits"+ searchResponse.getHits().getTotalHits());
		        System.out.println("elasticsearch response: {} hits .toostring"+searchResponse.toString());
		       // searchResponse.getHits().
		        Aggregations aggregations = searchResponse.getAggregations();
		        Terms contractSums = searchResponse.getAggregations().get("colors");
		        for (Terms.Bucket bucket : contractSums.getBuckets()) {
		        	System.out.println("KEY:"+bucket.getKey()+"!!keyAsString:"+bucket.getKeyAsString()+"!!count:"+bucket.getDocCount());
		        	
		        }
		      
		        return objectMapper.convertValue(contractSums.getBuckets(),List.class);
		}
	
	
	
	
	
}
