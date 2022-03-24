package com.tweetservice.tweetservice.service;

import com.tweetservice.tweetservice.entity.TweetEntity;
import com.tweetservice.tweetservice.model.Tweet;
import com.tweetservice.tweetservice.repository.TweetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetServiceImpl implements TweetService {

    private TweetRepository tweetRepository;

    public TweetServiceImpl(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @Override
    public Tweet saveTweet(Tweet tweet) {
        TweetEntity tweetEntity = new TweetEntity();
        BeanUtils.copyProperties(tweet, tweetEntity);
        tweetRepository.save(tweetEntity);
        return tweet;
    }

    @Override
    public List<Tweet> getAllTweets() {
        List<TweetEntity> tweetEntities
                = tweetRepository.findAll();
        List<Tweet> tweets = tweetEntities
                .stream()
                .map(tweetEntity -> new Tweet(
                        tweetEntity.getTweetId(),
                        tweetEntity.getTweetUserName(),
                        tweetEntity.getTweetImage(),
                        tweetEntity.getTweetUserTag(),
                        tweetEntity.getTweetText(),
                        tweetEntity.getTweetTimeStamp(),
                        tweetEntity.getRetweetCount(),
                        tweetEntity.getLikeCount()

                ))
                .collect(Collectors.toList());

        return tweets;
    }

    @Override
    public Tweet getTweetById(Long id) {
        TweetEntity tweetEntity
                = tweetRepository.findById(id).get();
        Tweet tweet = new Tweet();
        BeanUtils.copyProperties(tweetEntity, tweet);
        return tweet;
    }

    @Override
    public boolean deleteTweet(Long id) {
        TweetEntity tweet = tweetRepository.findById(id).get();
        tweetRepository.delete(tweet);
        return true;

    }

    @Override
    public Tweet updateTweet(Long id, Tweet tweet) {
        TweetEntity tweetEntity =
                tweetRepository.findById(id).get();


        tweetRepository.save(tweetEntity);
        return tweet;
    }
}
