package com.tweetservice.tweetservice.messaging;

import com.tweetservice.tweetservice.entity.TweetEntity;
import com.tweetservice.tweetservice.model.Tweet;
import com.tweetservice.tweetservice.service.TweetService;
import org.json.simple.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

@Service
public class RabbitMQListener {

    private TweetService tweetService;

    public RabbitMQListener(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consumeMessageFromQueue(JSONObject message) {
        System.out.println(message);
        updateTweetUserTag(message);
    }

    private void updateTweetUserTag(JSONObject updatedUser) {
        String updatedUserTag = updatedUser.get("tag").toString();
        String updatedUserId = updatedUser.get("id").toString();
        List<TweetEntity> tweetsByUser = tweetService.findByTweetUserId(updatedUserId);
        for(TweetEntity tweet : tweetsByUser) {
            if(tweet.getTweetUserId() == null) {
                return;
            }
            if(tweet.getTweetUserTag() == updatedUserTag) {
                return;
            }
            tweet.tweetUserTag = updatedUserTag;
            tweetService.save(tweet);
        }


    }
}
