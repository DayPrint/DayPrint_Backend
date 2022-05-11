package multicampus.dayprint_backend.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
@ApiModel(value = "회원가입 응답 정보")
@Getter
@AllArgsConstructor
public class JoinRes {

    private Long id;

    private String email;
}
