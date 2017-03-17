package main.java.es.unizar.tmdad.lab0.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.es.unizar.tmdad.lab0.service.TwitterLookupService;


@Controller
public class SearchController {

	private static final Logger logger = Logger.getLogger(SearchController.class);
	
    @Autowired
    TwitterLookupService twitter;

    @RequestMapping("/")
    public String greeting() {
        return "index";
    }

    @RequestMapping("/search")
    public void search(@RequestParam("q") String q) {
    	twitter.search(q);
    	
    	logger.info("/search called with param q="+q);
    }
}