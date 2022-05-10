package multicampus.dayprint_backend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import multicampus.dayprint_backend.dto.comment.CommentReq;
import multicampus.dayprint_backend.dto.comment.CommentRes;
import multicampus.dayprint_backend.entity.CommentInfo;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.exeception.BaseException;
import multicampus.dayprint_backend.exeception.BaseResponseCode;
import multicampus.dayprint_backend.repository.CommentInfoRepository;
import multicampus.dayprint_backend.repository.PostInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CommentInfoService {

    private final CommentInfoRepository commentInfoRepository;
    private final PostInfoService postInfoService;

    public CommentInfo findComment(Long id){
        CommentInfo commentInfo = commentInfoRepository.findById(id)
                .orElseThrow(() -> new BaseException(BaseResponseCode.FAILED_TO_FIND_COMMENT));

        return commentInfo;
    }

    public List<CommentRes> findComments(Long postId) {
        PostInfo post = postInfoService.findPost(postId);
        List<CommentInfo> commentInfos = post.getCommentInfos();

        List<CommentRes> list = new ArrayList<>();
        commentInfos.forEach( o -> list.add(new CommentRes(o)));

        return list;
    }

    public CommentRes createComment(Long postId, CommentReq commentReq) {
        PostInfo post = postInfoService.findPost(postId);
        CommentInfo commentInfo;
        try {
            commentInfo = commentInfoRepository.save(CommentInfo.builder()
                    .author(commentReq.getAuthor())
                    .text(commentReq.getText())
                    .postInfo(post)
                    .build());
        } catch (Exception e){
            throw new BaseException(BaseResponseCode.FAILED_TO_SAVE_COMMENT);
        }
        return new CommentRes(commentInfo);
    }
}
