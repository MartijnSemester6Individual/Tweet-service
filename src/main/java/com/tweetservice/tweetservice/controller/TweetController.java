package com.tweetservice.tweetservice.controller;

import com.tweetservice.tweetservice.model.Tweet;
import com.tweetservice.tweetservice.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
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

    @DeleteMapping("/tweets/{id}/{userId}")
    public ResponseEntity<Map<String, Boolean>> deleteTweet(@PathVariable("id") Long id, @PathVariable("userId") String userId) {
        boolean deleted = false;
        Tweet tweet = null;
        tweet = tweetService.getTweetById(id);
        Map<String, Boolean> response = new HashMap<>();

        if(tweet.getTweetUserId().equals(userId)) {
            deleted = tweetService.deleteTweet(id);
            response.put("deleted", deleted);
            return ResponseEntity.ok(response);
        }
        response.put("invalid request", false);
        return ResponseEntity.badRequest().body(response);
    }
}

