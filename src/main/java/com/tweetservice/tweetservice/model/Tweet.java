package com.tweetservice.tweetservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tweet {

    private long tweetId;
    public String tweetUserId;
    public String tweetUserName;
    public String tweetUserImage;
    public String tweetImage;
    public String tweetUserTag;
    public String tweetText;
    public String tweetTimeStamp;
    public Integer retweetCount;
    public Integer likeCount;

    public Tweet(long tweetId, String tweetUserId, String tweetUserName, String tweetUserImage,
                 String tweetImage, String tweetUserTag, String tweetText, String tweetTimeStamp, Integer retweetCount, Integer likeCount) {
        this.tweetId = tweetId;
        this.tweetUserId = tweetUserId;
        this.tweetUserName = tweetUserName;
        this.tweetUserImage = tweetUserImage;
        this.tweetImage = tweetImage;
        this.tweetUserTag = tweetUserTag;
        this.tweetText = tweetText;
        this.tweetTimeStamp = tweetTimeStamp;
        this.retweetCount = retweetCount;
        this.likeCount = likeCount;
    }

    public Tweet() {

    }

    public Tweet(String tweetUserId, String tweetUserTag) {
        this.tweetUserId = tweetUserId;
        this.tweetUserTag = tweetUserTag;
    }
}
