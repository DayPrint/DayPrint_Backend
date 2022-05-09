package multicampus.dayprint_backend.service;

import lombok.extern.slf4j.Slf4j;
import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.repository.UserRepository;
import multicampus.dayprint_backend.repository.PostInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

@Slf4j
@Service
@Transactional
public class PostInfoService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostInfoRepository postInfoRepository;

    public PostInfo findPost(Long id){
        return postInfoRepository.findById(id).orElse(new PostInfo());
    }

    public PostInfo createUserPost(Long id, PostInfo postInfo){
        User user = userService.findUser(id);
        user.addPost(postInfo);
        return postInfoRepository.save(postInfo);
    }

    public PostInfo updateUserPost(Long id, PostInfo postInfo, Long postId){
        User user = userService.findUser(id);
        PostInfo original = findPost(postId);
        user.removePost(original);
        user.addPost(postInfo);
        original.setTitle(postInfo.getTitle());
        original.setPostContent(postInfo.getPostContent());
        return original;
    }

    public ResponseEntity<?> deleteUserPost(Long id, Long postId){
        User user = userService.findUser(id);
        PostInfo post = findPost(postId);
        user.removePost(post);
        postInfoRepository.delete(post);
        return ResponseEntity.ok().build();
    }
}
