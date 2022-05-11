package multicampus.dayprint_backend.dto.comment;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import multicampus.dayprint_backend.entity.CommentInfo;

@ApiModel(value = "댓글 응답 정보")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRes {

    private Long id;

    private String author;

    private String text;

    private Long postId;

    private String postTitle;

    public CommentRes(CommentInfo commentInfo){
        id = commentInfo.getId();
        author= commentInfo.getAuthor();
        text = commentInfo.getText();
        postId = commentInfo.getPostInfo().getId();
        postTitle = commentInfo.getPostInfo().getTitle();
    }
}
