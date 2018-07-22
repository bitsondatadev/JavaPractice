package us.brianolsen.twitter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.social.twitter.api.FilterStreamParameters;
import org.springframework.social.twitter.api.Stream;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TwitterController.TWITTER_BASE_URI)
public class TwitterController {
	public static final String TWITTER_BASE_URI = "v1/tweets";
	
	@Autowired
	private Twitter twitter;
	
	private Stream stream;
	
	private StreamListener streamListener = new StreamListener(){

		@Override
		public void onTweet(Tweet tweet) {
			System.out.println(tweet.toString());
		}

		@Override
		public void onDelete(StreamDeleteEvent deleteEvent) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onLimit(int numberOfLimitedTweets) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onWarning(StreamWarningEvent warningEvent) {
			System.err.println("oh noooooo");
			
		}
	
	};
	
	@RequestMapping(value="{term}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweetsByTerm(@PathVariable final String term){
		return twitter.searchOperations().search(term).getTweets();
	}
	
	
}
