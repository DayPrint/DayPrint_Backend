package multicampus.dayprint_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import multicampus.dayprint_backend.dto.post.PostReq;
import multicampus.dayprint_backend.dto.post.PostRes;
import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.exeception.BaseException;
import multicampus.dayprint_backend.exeception.BaseResponse;
import multicampus.dayprint_backend.exeception.BaseResponseCode;
import multicampus.dayprint_backend.repository.UserRepository;
import multicampus.dayprint_backend.repository.PostInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@RequiredArgsConstructor
@Slf4j
@Service
@Transactional
public class PostInfoService {

    private final UserService userService;
    private final PostInfoRepository postInfoRepository;

    public PostInfo findPost(Long id){
        PostInfo postInfo = postInfoRepository.findById(id)
                .orElseThrow(()->new BaseException(BaseResponseCode.FAILED_TO_FIND_POST));

        return postInfo;
    }

    public PostRes createUserPost(Long id, PostReq postReq){
        LocalDate date = LocalDate.parse(postReq.getTargetDate());
        User user = userService.findUserById(id);
        PostInfo post;
        try {
             post = postInfoRepository.save(PostInfo.builder()
                     .title(postReq.getTitle())
                     .postContent(postReq.getPostContent())
                     .targetDate(date)
                     .imageUrl(postReq.getImageUrl())
                     .theme(postReq.getTheme())
                     .user(user)
                     .build());
        } catch (Exception e){
            throw new BaseException(BaseResponseCode.FAILED_TO_SAVE_POST);
        }
        return new PostRes(post);
    }

    @Transactional
    public PostRes updateUserPost(Long id, Long postId, PostReq postReq) {
        User user = userService.findUserById(id);
        PostInfo originalPost = findPost(postId);
        LocalDate date = LocalDate.parse(postReq.getTargetDate());

        user.removePost(originalPost);
        originalPost.setTitle(postReq.getTitle());
        originalPost.setPostContent(postReq.getPostContent());
        originalPost.setTargetDate(date);
        originalPost.setImageUrl(postReq.getImageUrl());
        originalPost.setTheme(postReq.getTheme());
        user.addPost(originalPost);

        return new PostRes(originalPost);
    }

    public PostRes deleteUserPost(Long postId) {
        PostInfo post = findPost(postId);
        User user = post.getUser();
        user.removePost(post);
        postInfoRepository.delete(post);
        return new PostRes(post);
    }
}
