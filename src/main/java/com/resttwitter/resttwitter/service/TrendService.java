package com.resttwitter.resttwitter.service;

import com.resttwitter.resttwitter.Repository.WOEIDRepository;
import com.resttwitter.resttwitter.RestConsumer.RestConsumer;
import com.resttwitter.resttwitter.entities.TrendsObject;
import com.resttwitter.resttwitter.entities.WOEIDObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
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
        Streamable<WOEIDObject> ids = null;
        if(WOEIDRepository.existsById(city)){
            id = WOEIDRepository.findByNameIgnoreCase(city);
        }else {
            // to-do filter the most appropriate name
            ids = WOEIDRepository.findByNameIgnoreCaseContaining(city.substring(1,4));
             id = ids.iterator().next();
        }

        final TrendsObject trendsObject = consumerRepository.callTwitterAPI(id.getWOEID());
        return trendsObject;
    }

    }
