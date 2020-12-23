package com.lpnu.entity;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private String nickname;
    private LocalDate birth;

    private List<Bookmark> bookmarks;

    public User() {
    }

    public User(final Long id, final String nickname, final LocalDate birth, final List<Bookmark> bookmarks) {
        this.id = id;
        this.nickname = nickname;
        this.birth = birth;
        this.bookmarks = bookmarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(final LocalDate birth) {
        this.birth = birth;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(final List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
