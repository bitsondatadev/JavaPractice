package us.brianolsen.twitter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.FilterStreamParameters;
import org.springframework.social.twitter.api.Stream;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TwitterController2.TWITTER_BASE_URI)
public class TwitterController2 {
	public static final String TWITTER_BASE_URI = "v1/streamTweets";
	
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
			System.err.println("oh noooooo");
		}

		@Override
		public void onLimit(int numberOfLimitedTweets) {
			System.err.println("oh noooooo");
		}

		@Override
		public void onWarning(StreamWarningEvent warningEvent) {
			System.err.println("oh noooooo");
		}
	
	};
	

	@RequestMapping("openTweetStream")
	public void openTweetStream() throws InterruptedException{
		if(stream == null){
			FilterStreamParameters params = new FilterStreamParameters();
			params.addLocation(-136.022695f, 22.193047f, -50.387834f, 51.457928f);
			stream = twitter.streamingOperations().sample(Arrays.asList(streamListener));
					//.filter(params, Arrays.asList(streamListener));
			Thread.sleep(60 * 1000);
		}else{
			stream.close();
			stream = null;
		}
		
	}
	
}
