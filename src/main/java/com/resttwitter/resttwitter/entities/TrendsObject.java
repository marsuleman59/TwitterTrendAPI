package com.resttwitter.resttwitter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrendsObject {
    private List<Trend> trends;

    private String as_of;

    private String created_at;

    private List<Location> locations;

}
