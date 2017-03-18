package main.java.es.unizar.tmdad.lab0.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import main.java.es.unizar.tmdad.lab0.entity.TwitterQuery;
import main.java.es.unizar.tmdad.lab0.service.TwitterLookupService;

@Controller
public class SearchController {

	private static final Logger logger = LoggerFactory.getLogger(SearchController.class);
	
    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/")
    public String greeting() {
    	logger.info("index requested");
        return "index";
    }

    @RequestMapping("/search")
    public void search(TwitterQuery twitterQuery) {
    	logger.info("/app/search called with param query="+twitterQuery);
    	twitter.search(twitterQuery.getQuery());
    }
}