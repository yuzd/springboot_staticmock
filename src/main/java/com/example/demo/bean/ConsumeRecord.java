package com.example.demo.bean;

import java.util.Date;

public class ConsumeRecord {
  private String userId;
  private String content;
  private Date consumeTimeStamp;

  public ConsumeRecord(String userId, String content, Date consumeTimeStamp) {
    this.userId = userId;
    this.content = content;
    this.consumeTimeStamp = consumeTimeStamp;
  }

  public ConsumeRecord() {
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getConsumeTimeStamp() {
    return consumeTimeStamp;
  }

  public void setConsumeTimeStamp(Date consumeTimeStamp) {
    this.consumeTimeStamp = consumeTimeStamp;
  }

  @Override
  public String toString() {
    return "ConsumeRecord{" +
        "userId='" + userId + '\'' +
        ", content='" + content + '\'' +
        ", consumeTimeStamp=" + consumeTimeStamp +
        '}';
  }
}
