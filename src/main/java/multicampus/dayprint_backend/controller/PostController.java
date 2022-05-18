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

@Api(tags = {"게시글에 대한 CR을 제공하는 Controller"})
//@CrossOrigin(origins="*", value = "*", allowedHeaders = "*",exposedHeaders = "*")
@CrossOrigin("*")
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
        System.out.println(postReq.toString());
        return postInfoService.createUserPost(id, postReq);
    }
}
