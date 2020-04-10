package com.resttwitter.resttwitter.service;

import com.resttwitter.resttwitter.Repository.WOEIDRepository;
import com.resttwitter.resttwitter.entities.WOEIDObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class WOEIDService {

    @Autowired
    WOEIDRepository WOEIDRepository;

    public void storeWOEID() throws IOException {
        BufferedReader bufferedReader;
        ArrayList<WOEIDObject> woeidObjects = new ArrayList<>();

            try {
                bufferedReader = new BufferedReader(new FileReader("D:\\Development\\Twitter API\\Twitter API WOEID.csv"));
                String line = null;
                while (null != (line = bufferedReader.readLine())) {
                    String[] array = line.split(",");
                    System.out.println(Arrays.toString(array));
                    WOEIDObject woeidObject = WOEIDObject.builder().name(array[0]).country(array[1]).WOEID(array[2]).countryCode(array[3]).build();
                    woeidObjects.add(woeidObject);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("Debug");
        WOEIDRepository.saveAll(woeidObjects);

    }

}
