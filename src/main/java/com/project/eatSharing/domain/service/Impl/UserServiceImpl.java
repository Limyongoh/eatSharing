package com.project.eatSharing.domain.service.Impl;

import com.project.eatSharing.domain.common.encrypt.SHA256;
import com.project.eatSharing.domain.dto.user.UserDto;
import com.project.eatSharing.domain.entity.User;
import com.project.eatSharing.domain.repository.UserRepository;
import com.project.eatSharing.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public boolean emailExists(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean nickNameExists(String nickName) {
        return userRepository.existsByNickName(nickName);
    }

    @Override
    public Long userSignUp(UserDto userDto) {

        User createUser = User.builder().email(userDto.getEmail())
                .password(passwordEncrypt(userDto.getPassword()))
                .nickName(userDto.getNickName())
                .name(userDto.getName())
                .phoneNumber(userDto.getPhoneNumber())
                .build();
        userRepository.save(createUser);

        return createUser.getId();
    }


    @Override
    public Long userSignIn(UserDto userDto) {
        log.info("userDto.getPassword() -> " + userDto.getPassword());
        Optional<User> optionalLoginUser = userRepository.findByEmail(userDto.getEmail());

        if(optionalLoginUser.isPresent()
                && optionalLoginUser.get().getPassword().equals(passwordEncrypt(userDto.getPassword()))) {
            return optionalLoginUser.get().getId();
        }
        else {
            return null;
        }
    }

    /**
     * password 암호화
     */
    protected String passwordEncrypt(String text)  {
        String encrypt = "";

        try {
            encrypt = new SHA256().encrypt(text);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password {}", e);
        }
        return encrypt;
    }


}
