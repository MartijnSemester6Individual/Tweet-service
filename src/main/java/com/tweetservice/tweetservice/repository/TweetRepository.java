package com.tweetservice.tweetservice.repository;

import com.tweetservice.tweetservice.entity.TweetEntity;
import com.tweetservice.tweetservice.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TweetRepository extends JpaRepository<TweetEntity, Long> {
    List<TweetEntity> findByTweetUserId(String tweetUserId);

}
