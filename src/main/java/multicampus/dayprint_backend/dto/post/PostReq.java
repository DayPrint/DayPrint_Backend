package multicampus.dayprint_backend.dto.post;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@ApiModel(value = "게시글 요청 정보")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostReq {

    private String userId;

    private String title;

    private String postContent;

    private String imageUrl;

    private String theme;

    @ApiModelProperty(value = "기념일 날짜", example = "꼭 yyyy-mm-dd 형식으로 입력해주세요", required = true)
    private String targetDate;
}
