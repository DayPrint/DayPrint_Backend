package multicampus.dayprint_backend.dto.post;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import multicampus.dayprint_backend.entity.PostInfo;

import java.time.LocalDate;

@ApiModel(value = "게시글 응답 정보")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRes {

    private Long id;

    private String title;

    private String content;

    private String imageUrl;

    private String theme;

    private LocalDate targetDate;

    public PostRes(PostInfo postInfo){
        id = postInfo.getId();
        title=postInfo.getTitle();
        content=postInfo.getPostContent();
        targetDate=postInfo.getTargetDate();
        imageUrl=postInfo.getImageUrl();
        theme=postInfo.getTheme();
    }
}
