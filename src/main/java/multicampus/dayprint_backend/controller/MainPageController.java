package multicampus.dayprint_backend.controller;

import multicampus.dayprint_backend.entity.PostInfo;
import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public List<PostInfo> userPostList(@PathVariable Long id){
        User user = userService.findUser(id);
        return user.getPostInfos();
    }
}
