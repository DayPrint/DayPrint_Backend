package multicampus.dayprint_backend.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import multicampus.dayprint_backend.entity.PostInfo;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostRes {

    private Long id;

    private String title;

    private String content;

    private LocalDate targetDate;

    public PostRes(PostInfo postInfo){
        id = postInfo.getId();
        title=postInfo.getTitle();
        content=postInfo.getPostContent();
        targetDate=postInfo.getTargetDate();
    }
}
