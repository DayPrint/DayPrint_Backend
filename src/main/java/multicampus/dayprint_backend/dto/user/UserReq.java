package multicampus.dayprint_backend.dto.user;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@ApiModel(value = "회원가입 요청 정보")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserReq {

    private String name;

    private String phone;

    private String email;

    private String password;

    private String imageUrl;
}
