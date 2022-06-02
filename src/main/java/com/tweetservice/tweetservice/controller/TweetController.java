package com.tweetservice.tweetservice.controller;

import com.tweetservice.tweetservice.model.Tweet;
import com.tweetservice.tweetservice.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v2/")
public class TweetController {

    private TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }


    @PostMapping("/tweet")
    public Tweet saveTweet(@RequestBody Tweet tweet) {
        return tweetService.saveTweet(tweet);
    }

    @GetMapping("/tweets")
    public List<Tweet> getAllTweetsOrderDesc() {
        return tweetService.getAllTweetsOrderDesc();
    }

    @GetMapping("/tweets/{id}")
    public ResponseEntity<Tweet> GetTweetById(@PathVariable("id") Long id) {
        Tweet tweet = null;
        tweet = tweetService.getTweetById(id);
        return ResponseEntity.ok(tweet);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTweet(@PathVariable("id") String id) {
        Long tweetId = Long.parseLong(id);
        boolean deleted = false;
        Tweet tweet = null;
        tweet = tweetService.getTweetById(tweetId);
        Map<String, Boolean> response = new HashMap<>();

        if(tweet == null) {
            response.put("invalid request", false);
            return ResponseEntity.badRequest().body(response);
        }

        deleted = tweetService.deleteTweet(tweetId);
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);


    }
}

