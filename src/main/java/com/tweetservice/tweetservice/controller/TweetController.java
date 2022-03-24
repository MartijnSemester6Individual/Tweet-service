package com.tweetservice.tweetservice.controller;

import com.tweetservice.tweetservice.model.Tweet;
import com.tweetservice.tweetservice.service.TweetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        System.out.println(tweet);
        return tweetService.saveTweet(tweet);
    }

    @GetMapping("/tweets")
    public List<Tweet> getAllTweets() {
        return tweetService.getAllTweets();
    }

    @GetMapping("/tweets/{id}")
    public ResponseEntity<Tweet> GetTweetById(@PathVariable("id") Long id) {
        Tweet tweet = null;
        tweet = tweetService.getTweetById(id);
        return ResponseEntity.ok(tweet);
    }

    @DeleteMapping("/tweets/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTweet(@PathVariable("id") Long id) {
        boolean deleted = false;
        deleted = tweetService.deleteTweet(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/tweets/{id}")
    public ResponseEntity<Tweet> updateTweet(@PathVariable("id") Long id,
                                           @RequestBody Tweet tweet) {
        tweet = tweetService.updateTweet(id, tweet);
        return ResponseEntity.ok(tweet);
    }
}
