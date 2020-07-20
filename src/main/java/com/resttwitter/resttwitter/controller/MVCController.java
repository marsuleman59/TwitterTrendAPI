package com.resttwitter.resttwitter.controller;

import com.resttwitter.resttwitter.entities.TrendsObject;
import com.resttwitter.resttwitter.service.TrendService;
import com.resttwitter.resttwitter.service.WOEIDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;

@Controller
public class MVCController {

    @Autowired
    WOEIDService woeidService;

    @Autowired
    TrendService trendService;


    @GetMapping({"","/"})
    public String indexCall(Model model) {
        return "index"; //view
    }

    @RequestMapping("/search")
    public String searchCity (@RequestParam(value = "searchCityParam", required = true) String searchCityParam, Model model) throws IOException {
        ModelAndView modelAndView = new ModelAndView();
        final TrendsObject trend = trendService.getWOEID(searchCityParam);
        model.addAttribute("trends",trend.getTrends());
        return "index";
    }


}
