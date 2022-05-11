package multicampus.dayprint_backend.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@ApiModel(value = "로그인 응답 정보")
@Getter
@AllArgsConstructor
public class LoginRes {

    private Long id;

    private String jwtToken;
}
