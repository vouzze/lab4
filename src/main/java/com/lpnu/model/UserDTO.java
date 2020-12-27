package com.lpnu.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import java.time.LocalDate;

public class UserDTO {
    private Long id;
    @NotNull
    @NotBlank
    @Size(min = 3, max = 30)
    private String nickname;
    @NotNull
    @Past
    private LocalDate birth;

    public UserDTO() {
    }

    public UserDTO(final Long id, final String nickname, @NotNull final LocalDate birth) {
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
