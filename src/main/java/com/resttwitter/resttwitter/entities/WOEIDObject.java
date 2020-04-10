package com.resttwitter.resttwitter.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class WOEIDObject {

    @Id
    private String name;
    private String country;

    private String WOEID;
    private String countryCode;


}
