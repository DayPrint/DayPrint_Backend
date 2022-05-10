package multicampus.dayprint_backend.controller;

import lombok.RequiredArgsConstructor;
import multicampus.dayprint_backend.dto.comment.CommentReq;
import multicampus.dayprint_backend.dto.comment.CommentRes;
import multicampus.dayprint_backend.service.CommentInfoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentInfoService commentInfoService;

    @GetMapping("/{postId}")
    public List<CommentRes> getCommentList(@PathVariable Long postId){
        return commentInfoService.findComments(postId);
    }

    @PostMapping("/{postId}")
    public CommentRes createComment(@PathVariable Long postId, @RequestBody CommentReq commentReq){
        return commentInfoService.createComment(postId, commentReq);
    }
}
