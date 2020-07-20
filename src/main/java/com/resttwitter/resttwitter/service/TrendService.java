package com.resttwitter.resttwitter.service;

import com.resttwitter.resttwitter.Repository.WOEIDRepository;
import com.resttwitter.resttwitter.RestConsumer.RestConsumer;
import com.resttwitter.resttwitter.entities.TrendsObject;
import com.resttwitter.resttwitter.entities.WOEIDObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TrendService {


    @Autowired
    WOEIDRepository WOEIDRepository;

    @Autowired
    RestConsumer consumerRepository;


    public  TrendsObject getWOEID(String city) throws IOException {

        WOEIDObject id = null;
        if(WOEIDRepository.existsById(city)){
            id = WOEIDRepository.findById(city).get();
        }else {
            id = WOEIDRepository.findByNameIgnoreCaseContaining(city);
        }

        final TrendsObject trendsObject = consumerRepository.callTwitterAPI(id.getWOEID());
        return trendsObject;
    }

    }
