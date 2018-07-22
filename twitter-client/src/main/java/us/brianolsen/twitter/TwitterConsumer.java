package us.brianolsen.twitter;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.social.twitter.api.Stream;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

//@Component("twitterConsumer")
public class TwitterConsumer {
	private Stream _stream;
	
	private Twitter twitter;

	private StreamListener _streamListener = new StreamListener(){

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
	
	public TwitterConsumer(){
		_stream = twitter.streamingOperations().sample(Arrays.asList(_streamListener));

	}
	
	public void shutdown(){
		try {
			((Thread)_stream).join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		_stream.close();
	}

}
