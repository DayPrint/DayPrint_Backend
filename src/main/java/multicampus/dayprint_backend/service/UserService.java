package multicampus.dayprint_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import multicampus.dayprint_backend.dto.post.PostRes;
import multicampus.dayprint_backend.dto.user.JoinRes;
import multicampus.dayprint_backend.dto.user.LoginRes;
import multicampus.dayprint_backend.dto.user.UserReq;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.exeception.BaseException;
import multicampus.dayprint_backend.exeception.BaseResponseCode;
import multicampus.dayprint_backend.repository.UserRepository;
import multicampus.dayprint_backend.utils.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public boolean existsUser(String email) {
        return userRepository.existsByEmail(email);
    }

    // 회원가입
    @Transactional
    public JoinRes createUser(UserReq req) {
        User user;

        try {
            user = userRepository.save(User.builder()
                    .name(req.getName())
                    .phone(req.getPhone())
                    .email(req.getEmail())
                    .password(passwordEncoder.encode(req.getPassword()))
                    .imageUrl(req.getImageUrl())
                    .build());
        } catch (Exception e) {
            throw new BaseException(BaseResponseCode.FAILED_TO_SAVE_USER);
        }

        return new JoinRes(user.getId(), user.getEmail());
    }

    // 로그인
    public LoginRes login(String email) {
        User user = findUser(email);
        String token = jwtTokenProvider.createToken(email);

        return new LoginRes(user.getId(),user.getName(), token);
    }



    // email 활용 유저조회
    public User findUser(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new BaseException(BaseResponseCode.FAILED_TO_FIND_USER));

        return user;
    }

    //id 활용 유저조회
    public User findUserById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseCode.FAILED_TO_FIND_USER));

        return user;
    }

    //userPost 리스트 조회
    public List<PostRes> findPosts(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseCode.FAILED_TO_FIND_POST));

        List<PostRes> list = new ArrayList<>();
        user.getPostInfos().forEach( o -> list.add(new PostRes(o)));
        return list;
    }

}
