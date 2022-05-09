package multicampus.dayprint_backend.service;

import lombok.extern.slf4j.Slf4j;
import multicampus.dayprint_backend.entity.CommentInfo;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.repository.CommentInfoRepository;
import multicampus.dayprint_backend.repository.PostInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CommentInfoService {
    @Autowired
    private CommentInfoRepository commentInfoRepository;
    @Autowired
    private PostInfoRepository postInfoRepository;
    @Autowired
    private PostInfoService postInfoService;

    public CommentInfo findComment(Long id){
        return commentInfoRepository.findById(id).orElse(new CommentInfo());
    }

    public CommentInfo createComment(Long postId, CommentInfo commentInfo){
        PostInfo post = postInfoService.findPost(postId);
        post.addComment(commentInfo);
        return commentInfoRepository.save(commentInfo);
    }
}
