package com.resttwitter.resttwitter.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trend {
    private String name;

    private String url;

    private String promoted_content;

    private String query;

    private int tweet_volume;



}
