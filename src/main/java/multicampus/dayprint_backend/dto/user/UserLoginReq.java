package multicampus.dayprint_backend.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(value = "로그인 요청 정보")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginReq {

    private String email;

    private String password;
}
