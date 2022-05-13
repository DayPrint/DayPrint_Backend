package multicampus.dayprint_backend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import multicampus.dayprint_backend.dto.post.PostReq;
import multicampus.dayprint_backend.dto.post.PostRes;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.service.PostInfoService;
import multicampus.dayprint_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"게시글에 대한 CRUD를 제공하는 Controller"})
@CrossOrigin(value = "*", allowedHeaders = "*",exposedHeaders = "Authorization")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final UserService userService;
    private final PostInfoService postInfoService;

    @ApiOperation(value = "유저 id를 통해 게시글 리스트를 제공하는 메소드")
    @GetMapping("/{id}")
    public List<PostRes> getPostList(@PathVariable Long id){
        return userService.findPosts(id);
    }

    @ApiOperation(value = "게시글을 유저id에 맞게 저장하는 기능의 메소드")
    @PostMapping("/{id}")
    public PostRes createPost(@PathVariable Long id, @RequestBody PostReq postReq){
        return postInfoService.createUserPost(id, postReq);
    }

    @ApiOperation(value = "유저 id와 게시글 id 그리고 변경된 값을 통해 수정하는 메소드")
    @PutMapping("/{id}/{postId}")
    public PostRes updatePost(@PathVariable Long id, @PathVariable Long postId, @RequestBody PostReq postReq){
        return postInfoService.updateUserPost(id, postId, postReq);
    }

    @ApiOperation(value = "게시글 id를 통해서 삭제하는 메소드")
    @DeleteMapping("/{postId}")
    public PostRes deletePost(@PathVariable Long postId){
        return postInfoService.deleteUserPost(postId);
    }
}
