package com.lpnu.dto;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    private String nickname;
    private LocalDate birth;

    public UserDTO() {
    }

    public UserDTO(final Long id, final String nickname, final LocalDate birth) {
        this.id = id;
        this.nickname = nickname;
        this.birth = birth;
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
}
