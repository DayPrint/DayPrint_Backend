package multicampus.dayprint_backend.dto.comment;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(value = "댓글 요청 정보")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentReq {

    private String author;

    private String text;
}
