package multicampus.dayprint_backend.controller;

import multicampus.dayprint_backend.entity.CommentInfo;
import multicampus.dayprint_backend.service.CommentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentInfoService commentInfoService;

    @PostMapping("/{postId}")
    public CommentInfo createComment(@PathVariable Long postId, @RequestBody CommentInfo commentInfo){
        return commentInfoService.createComment(postId, commentInfo);
    }

}
