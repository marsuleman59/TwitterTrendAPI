package com.resttwitter.resttwitter.RestConsumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resttwitter.resttwitter.entities.TrendsObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

public class RestConsumer {


    String oAuthData = "OAuth oauth_consumer_key=\"cI1i0Tcwemjp0xEPtLWOgwgJ6\",oauth_token=\"770896129-uTuXFAJBlNBG2CoV3iFAQNraMQELBrogrxPquvj9\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1586482844\",oauth_nonce=\"XAiBWKA66xA\",oauth_version=\"1.0\",oauth_signature=\"%2BbWMzbUHJrSmnsof7GnSof%2BEhUI%3D\"";

    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders httpHeaders = new HttpHeaders();

    ObjectMapper objectMapper = new ObjectMapper();

    public TrendsObject callTwitterAPI(String id) throws IOException {
        System.out.println("RCRepo start");

        String url = "https://api.twitter.com/1.1/trends/place.json?id="+id;
        System.out.println(url);
        httpHeaders.add("Authorization", oAuthData);
        HttpEntity<String> entity = new HttpEntity<String>(httpHeaders);


        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        String exchangeBody = exchange.getBody().substring(1,exchange.getBody().length()-1);
        System.out.println("RestConsumerRepo: "+exchangeBody);
        TrendsObject trendsRootObject = objectMapper.readValue(exchangeBody, TrendsObject.class);
        return trendsRootObject;
    }

}
