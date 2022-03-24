package com.tweetservice.tweetservice.service;

import com.tweetservice.tweetservice.model.Tweet;

import java.util.List;

public interface TweetService {
    Tweet saveTweet(Tweet tweet);

    List<Tweet> getAllTweets();

    Tweet getTweetById(Long id);

    boolean deleteTweet(Long id);

    Tweet updateTweet(Long id, Tweet tweet);

}
