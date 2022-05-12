package multicampus.dayprint_backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import multicampus.dayprint_backend.dto.comment.CommentReq;
import multicampus.dayprint_backend.dto.comment.CommentRes;
import multicampus.dayprint_backend.service.CommentInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"댓글 생성과 조회를 제공하는 Controller"})
@CrossOrigin(value = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentInfoService commentInfoService;

    @ApiOperation(value = "게시글 id에 맞는 댓글들을 보여주는 메소드")
    @GetMapping("/{postId}")
    public List<CommentRes> getCommentList(@PathVariable Long postId){
        return commentInfoService.findComments(postId);
    }

    @ApiOperation(value = "게시글 id에 맞게 댓글을 등록하는 메소드")
    @PostMapping("/{postId}")
    public CommentRes createComment(@PathVariable Long postId, @RequestBody CommentReq commentReq){
        return commentInfoService.createComment(postId, commentReq);
    }
}
