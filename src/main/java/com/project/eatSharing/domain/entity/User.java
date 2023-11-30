package com.project.eatSharing.domain.entity;

import com.project.eatSharing.domain.common.encrypt.SHA256;
import com.project.eatSharing.domain.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.security.NoSuchAlgorithmException;

@Entity(name = "TN_USER")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL")
    private String email;           // 이메일

    @Column(name = "PASSWORD")
    private String password;        // 비밀번호

    @Column(name = "NICK_NAME")
    private String nickName;        // 닉네임

    @Column(name = "NAME")
    private String name;            // 이름

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;     // 핸드폰번호



}
