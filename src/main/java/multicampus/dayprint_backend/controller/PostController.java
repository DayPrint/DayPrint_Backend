package multicampus.dayprint_backend.controller;

import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.service.PostInfoService;
import multicampus.dayprint_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private UserService userService;
    @Autowired
    private PostInfoService postInfoService;

    @GetMapping("/{postId}")
    public PostInfo selectPost(@PathVariable Long postId){
        return postInfoService.findPost(postId);
    }

    @PostMapping("/{id}")
    public PostInfo createPost(@PathVariable Long id, @RequestBody PostInfo postInfo){
        return postInfoService.createUserPost(id, postInfo);
    }

    @PutMapping("/{id}/{postId}")
    public PostInfo updatePost(@PathVariable Long id, @PathVariable Long postId , @RequestBody PostInfo postInfo){
        return postInfoService.updateUserPost(id, postInfo, postId);
    }

    @DeleteMapping("/{id}/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long id, @PathVariable Long postId){
        return postInfoService.deleteUserPost(id, postId);
    }
}
