package com.tweetservice.tweetservice.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tweets")
public class TweetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public TweetEntity(long tweetId, String tweetUserId, String tweetUserName, String tweetUserImage,
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

    public TweetEntity() {

    }

}

