package main.java.es.unizar.tmdad.lab0.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.util.MimeTypeUtils;

public class SimpleStreamListener implements StreamListener {

	private static final Logger logger = Logger.getLogger(SimpleStreamListener.class);
	
	private MessageSendingOperations<String> messageSendingOperations;
	private String query;
	
	public SimpleStreamListener(MessageSendingOperations<String> messageSendingOperations, String query){
		this.messageSendingOperations = messageSendingOperations;
		this.query = query;
	}
	
	@Override
	public void onDelete(StreamDeleteEvent ev) {
		logger.debug("Tweet onDelete event triggered on tweet whose ID is: " + ev.getTweetId());
	}

	@Override
	public void onLimit(int limit) {
		logger.debug("Tweet onLimit event triggered, limit: " + limit);
	}

	@Override
	public void onTweet(Tweet tweet) {
		logger.info("Received tweet from query "+ query +": " + tweet);
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
		// (destination, payload, headers)
		messageSendingOperations.convertAndSend("/queue/search/" + query, tweet, headers);
	}

	@Override
	public void onWarning(StreamWarningEvent ev) {
		logger.debug("Tweet onWarning event triggered, code: " + ev.getCode()
										+ "\n\t\tMsg: " + ev.getMessage());
	}

}
