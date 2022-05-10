package multicampus.dayprint_backend.controller;

import lombok.RequiredArgsConstructor;
import multicampus.dayprint_backend.dto.user.JoinRes;
import multicampus.dayprint_backend.dto.user.LoginRes;
import multicampus.dayprint_backend.dto.user.UserLoginReq;
import multicampus.dayprint_backend.dto.user.UserReq;
import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.exeception.BaseResponse;
import multicampus.dayprint_backend.exeception.BaseResponseCode;
import multicampus.dayprint_backend.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    // 회원가입
    @PostMapping("/join")
    public BaseResponse<JoinRes> join(@RequestBody UserReq userReq) {

        // 이미 존재하는 이메일
        if (userService.existsUser(userReq.getEmail())) {
            return new BaseResponse<>(BaseResponseCode.EXISTENT_EMAIL);
        }

        JoinRes joinRes = userService.createUser(userReq);
        return new BaseResponse<>(joinRes);

    }

    // 로그인
    @PostMapping("/login")
    public BaseResponse<LoginRes> login(@RequestBody UserLoginReq userLoginReq) {

        Boolean existAdmin = userService.existsUser(userLoginReq.getEmail());
        if (!existAdmin) {
            return new BaseResponse<>(BaseResponseCode.NON_EXISTENT_EMAIL);
        }

        User user = userService.findUser(userLoginReq.getEmail());
        if (!passwordEncoder.matches(userLoginReq.getPassword(), user.getPassword())) {
            return new BaseResponse<>(BaseResponseCode.WRONG_PWD);
        }

        LoginRes loginRes = userService.login(userLoginReq.getEmail());

        return new BaseResponse<>(loginRes);
    }


}
