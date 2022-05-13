package com.tweetservice.tweetservice.service;

import com.tweetservice.tweetservice.entity.TweetEntity;
import com.tweetservice.tweetservice.model.Tweet;
import com.tweetservice.tweetservice.repository.TweetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
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
    public List<Tweet> getAllTweetsOrderDesc() {
        List<TweetEntity> tweetEntities
                = tweetRepository.findAll(Sort.by(Sort.Direction.DESC, "tweetTimeStamp"));
        List<Tweet> tweets = tweetEntities
                .stream()
                .map(tweetEntity -> new Tweet(
                        tweetEntity.getTweetId(),
                        tweetEntity.getTweetUserId(),
                        tweetEntity.getTweetUserName(),
                        tweetEntity.getTweetUserImage(),
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
    public boolean updateTweet(Long id, Tweet updatedTweet) {
        if (tweetRepository.findById(id).isPresent()) {
            TweetEntity tweetEntity = tweetRepository.findById(id).get();
            tweetRepository.save(tweetEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<TweetEntity> findByTweetUserId(String id) {
        //List<TweetEntity> tweetEntities = tweetRepository.findByTweetUserId(id);
        return tweetRepository.findByTweetUserId(id);
    }

    @Override
    public TweetEntity save(TweetEntity tweetEntity) {
        return tweetRepository.save(tweetEntity);
    }

}
