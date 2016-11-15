package com.github.classyex.web.domain;

import java.util.Date;

/**
 * Created by yex on 16-11-12.
 */
public class Fragment {

    private String id;
    private User user;
    private String content;
    private Date createTime;

    public Fragment() {
    }

    public Fragment(String id, User user, String content, Date createTime) {
        this.id = id;
        this.user = user;
        this.content = content;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Fragment{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
