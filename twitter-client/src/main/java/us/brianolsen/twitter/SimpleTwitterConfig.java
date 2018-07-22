//package us.brianolsen.twitter;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.social.twitter.api.Twitter;
//import org.springframework.social.twitter.api.impl.TwitterTemplate;
//import org.springframework.web.context.annotation.RequestScope;
//
//@Configuration
//public class SimpleTwitterConfig {
//
//  private static Twitter twitter;
//
//  public SimpleTwitterConfig() {
//
//    if (twitter == null) {
//      twitter = new TwitterTemplate(null, null);
//    }
//  }
//
//  /**
//   * A proxy to a request-scoped object representing the simplest Twitter API
//   * - one that doesn't need any authorization
//   */
//  @Bean("twitterConfig")
//  @RequestScope
//  public Twitter twitter() {
//    return twitter;
//  }
//
//}