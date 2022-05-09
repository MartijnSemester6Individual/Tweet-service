package com.tweetservice.tweetservice.model;

public class Tweet {

    private long tweetId;
    private String tweetUserId;
    private String tweetUserName;
    private String tweetUserImage;
    private String tweetImage;
    private String tweetUserTag;
    private String tweetText;
    private String tweetTimeStamp;
    private Integer retweetCount;
    private Integer likeCount;

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

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweetUserId() {
        return tweetUserId;
    }

    public void setTweetUserId(String tweetUserId) {
        this.tweetUserId = tweetUserId;
    }

    public String getTweetUserName() {
        return tweetUserName;
    }

    public void setTweetUserName(String tweetUserName) {
        this.tweetUserName = tweetUserName;
    }

    public String getTweetUserImage() {
        return tweetUserImage;
    }

    public void setTweetUserImage(String tweetUserImage) {
        this.tweetUserImage = tweetUserImage;
    }

    public String getTweetImage() {
        return tweetImage;
    }

    public void setTweetImage(String tweetImage) {
        this.tweetImage = tweetImage;
    }

    public String getTweetUserTag() {
        return tweetUserTag;
    }

    public void setTweetUserTag(String tweetUserTag) {
        this.tweetUserTag = tweetUserTag;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }

    public String getTweetTimeStamp() {
        return tweetTimeStamp;
    }

    public void setTweetTimeStamp(String tweetTimeStamp) {
        this.tweetTimeStamp = tweetTimeStamp;
    }

    public Integer getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
}
