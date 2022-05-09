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

    public PostInfo createUserPost(Long id, PostInfo postInfo){
//        User user = userService.findUser(id);
//        user.addPost(postInfo);
        return postInfoRepository.save(postInfo);
    }


}
