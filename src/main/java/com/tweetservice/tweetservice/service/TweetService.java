package com.tweetservice.tweetservice.service;

import com.tweetservice.tweetservice.entity.TweetEntity;
import com.tweetservice.tweetservice.model.Tweet;

import java.util.List;
import java.util.Optional;

public interface TweetService {
    Tweet saveTweet(Tweet tweet);

    List<Tweet> getAllTweetsOrderDesc();

    Tweet getTweetById(Long id);

    boolean deleteTweet(Long id);

    boolean updateTweet(Long id, Tweet tweet);

    List<TweetEntity> findByTweetUserId(String id);

    TweetEntity save(TweetEntity tweet);
}
