package us.brianolsen.twitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	@RequestMapping(value="{term}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweet> getTweetsByTerm(@PathVariable final String term){
		return twitter.searchOperations().search(term).getTweets();
	}
	
//	@RequestMapping(value="getUSTweetsStream", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public List<Tweet> getUSTweets(){
//		List<StreamListener> listeners = Arrays.asList(_streamListener);
//		Stream stream = twitter.streamingOperations().sample(listeners);
//		//.filter((FilterStreamParameters)new FilterStreamParameters().addLocation(-136.022695f, 22.193047f, -50.387834f, 51.457928f), listeners);
//		return stream;
//	}
	
}
