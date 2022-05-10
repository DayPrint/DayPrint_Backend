package multicampus.dayprint_backend.controller;

import lombok.RequiredArgsConstructor;
import multicampus.dayprint_backend.dto.post.PostReq;
import multicampus.dayprint_backend.dto.post.PostRes;
import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.service.PostInfoService;
import multicampus.dayprint_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final UserService userService;
    private final PostInfoService postInfoService;

    @GetMapping("/{id}")
    public List<PostRes> getPostList(@PathVariable Long id){
        return userService.findPosts(id);
    }

    @PostMapping("/{id}")
    public PostRes createPost(@PathVariable Long id, @RequestBody PostReq postReq){
        return postInfoService.createUserPost(id, postReq);
    }

    @PutMapping("/{id}/{postId}")
    public PostRes updatePost(@PathVariable Long id, @PathVariable Long postId, @RequestBody PostReq postReq){
        return postInfoService.updateUserPost(id, postId, postReq);
    }

    @DeleteMapping("/{postId}")
    public PostRes deletePost(@PathVariable Long postId){
        return postInfoService.deleteUserPost(postId);
    }
}
