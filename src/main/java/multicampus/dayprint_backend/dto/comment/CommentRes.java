package multicampus.dayprint_backend.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import multicampus.dayprint_backend.entity.CommentInfo;

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
