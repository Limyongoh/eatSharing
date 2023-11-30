package com.project.eatSharing.domain.service;

import com.project.eatSharing.domain.dto.user.UserDto;


public interface UserService {

    /**
     * 이메일 체크
     * true : 존재
     * false : 없음
     */
    boolean emailExists(String email);

    /**
     * 닉네임 체크
     * true : 존재
     * false : 없음
     */
    boolean nickNameExists(String nickName);

    Long userSignUp(UserDto userDto);

    Long userSignIn(UserDto userDto);
}
