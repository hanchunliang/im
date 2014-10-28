package org.onelab.im.core.domain;

import java.util.Date;

/**
 * 消息描述
 * Created by chunliangh on 14-10-20.
 */
public class Message {
    /**
     * 类型
     */
    private int type;
    /**
     * 内容
     */
    private String content;
    /**
     * 作者
     */
    private String author;
    /**
     * 书写时间
     */
    private Date time;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
