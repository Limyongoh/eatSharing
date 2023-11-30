package com.project.eatSharing.domain.controller.user;

import static com.project.eatSharing.domain.customStatus.ResponseCode.LOGIN_FAIL;
import static com.project.eatSharing.domain.customStatus.ResponseCode.SUCCESS;

import com.project.eatSharing.domain.customStatus.ResultDtoEntity;
import com.project.eatSharing.domain.dto.user.UserDto;
import com.project.eatSharing.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    /**
     * email 중복체크
     */
    @GetMapping("/exists/user-email/{email}")
    ResultDtoEntity<Boolean> emailExists(@PathVariable String email){
        return ResultDtoEntity.resCodeMessage(userService.emailExists(email));
    }

    /**
     * nickName 중복체크
     */
    @GetMapping("/exists/user-nickName/{nickName}")
    ResultDtoEntity<Boolean> nickNameExists(@PathVariable String nickName){
        return ResultDtoEntity.resCodeMessage(userService.nickNameExists(nickName));
    }

    /**
     * 회원가입
     */
    @PostMapping("/signUp")
    public ResultDtoEntity<Long> signUp(@RequestBody UserDto userDto){
        return ResultDtoEntity.resCodeMessage(userService.userSignUp(userDto));
    }

    /**
     * 로그인
     */
    @PostMapping("/signIn")
    public ResultDtoEntity signIn(@RequestBody UserDto userDto) {
        Long loginUser = userService.userSignIn(userDto);

        if(loginUser != null){
            return ResultDtoEntity.resCodeMessage(HttpStatus.OK, SUCCESS.getMessage(),loginUser);
        }
        else{
            return ResultDtoEntity.resCodeMessage(HttpStatus.UNAUTHORIZED, LOGIN_FAIL.getMessage());

        }
    }

    /**
     * 회원정보 수정
     * */

}
