package com.project.eatSharing.domain.dto.user;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
@AllArgsConstructor
public class UserDto {
    private Long id;

    private String email;

    private String password;

    private String nickName;

    private String name;

    private String phoneNumber;

}
