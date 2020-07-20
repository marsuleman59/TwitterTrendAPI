package com.resttwitter.resttwitter.RestConsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resttwitter.resttwitter.entities.TrendsObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;

@Component
public class RestConsumer {

    @Value("${bearer.token}")
    String authToken;

    RestConsumer ( @Value("${bearer.token}") String authToken){
    this.authToken = authToken;
    }

    Logger logger = LoggerFactory.getLogger(RestConsumer.class);

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    ObjectMapper objectMapper = new ObjectMapper();

    public TrendsObject callTwitterAPI(String id) throws IOException {

        String url = "https://api.twitter.com/1.1/trends/place.json?id="+id;
        logger.debug(url);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("User-Agent", "Spring's RestTemplate" );  // value can be whatever
        headers.add("Authorization", "Bearer "+authToken );

        HttpEntity<String> entity = new HttpEntity<String>(headers);


        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String exchangeBody = exchange.getBody().substring(1,exchange.getBody().length()-1);
        logger.debug(exchangeBody);
        TrendsObject trendsRootObject = objectMapper.readValue(exchangeBody, TrendsObject.class);
        return trendsRootObject;
    }

}
