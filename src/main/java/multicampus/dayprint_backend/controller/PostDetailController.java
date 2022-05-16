package multicampus.dayprint_backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import multicampus.dayprint_backend.dto.post.PostReq;
import multicampus.dayprint_backend.dto.post.PostRes;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.service.PostInfoService;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"게시글 디테일에 대한 RUD를 제공하는 메소드"})
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/postdetail")
public class PostDetailController {

    private final PostInfoService postInfoService;

    @ApiOperation(value = "게시글 id를 통해서 특정 게시물의 정보 하나를 표시하는 메소드")
    @GetMapping("/{postId}")
    public PostRes getPostDetail(@PathVariable Long postId){
        return postInfoService.getUserPostDetail(postId);
    }

    @ApiOperation(value = "게시글 id 와 변경된 게시글 내용을 통해 수정하는 메소드")
    @PutMapping("/{postId}")
    public PostRes updatePost(@PathVariable Long postId, @RequestBody PostReq postReq){
        return postInfoService.updateUserPost(postId, postReq);
    }

    @ApiOperation(value = "게시글 id를 통해서 삭제하는 메소드")
    @DeleteMapping("/{postId}")
    public PostRes deletePost(@PathVariable Long postId){
        return postInfoService.deleteUserPost(postId);
    }
}
