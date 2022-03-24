package com.tweetservice.tweetservice.model;

public class Tweet {

    private long tweetId;
    private String tweetUserName;
    private String tweetImage;
    private String tweetUserTag;
    private String tweetText;
    private String tweetTimeStamp;
    private Integer retweetCount;
    private Integer likeCount;

    public Tweet(long tweetId, String tweetUserName, String tweetImage, String tweetUserTag, String tweetText, String tweetTimeStamp, Integer retweetCount, Integer likeCount) {
        this.tweetId = tweetId;
        this.tweetUserName = tweetUserName;
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

    public void setTweetId(long id) {
        this.tweetId = id;
    }

    public String getTweetUserName() {
        return tweetUserName;
    }

    public void setTweetUserName(String tweetUserName) {
        this.tweetUserName = tweetUserName;
    }

    public String getTweetImage() {
        return tweetImage;
    }

    public void setTweetImage(String userImage) {
        this.tweetImage = userImage;
    }

    public String getTweetUserTag() {
        return tweetUserTag;
    }

    public void setTweetUserTag(String userTag) {
        this.tweetUserTag = userTag;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String userInput) {
        this.tweetText = userInput;
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
