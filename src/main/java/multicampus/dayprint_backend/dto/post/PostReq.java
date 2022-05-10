package multicampus.dayprint_backend.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostReq {

    private String userId;

    private String title;

    private String postContent;

    private String targetDate;
}
