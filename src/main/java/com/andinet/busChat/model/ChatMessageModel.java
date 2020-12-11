package com.andinet.busChat.model;

import java.awt.*;

public class ChatMessageModel {

  private MessageType type;
  private String content;
  private String sender;

  //When someone joins it tells
  public  enum MessageType{
  CHAT,
      JOIN,
      LEAVE
  }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}

