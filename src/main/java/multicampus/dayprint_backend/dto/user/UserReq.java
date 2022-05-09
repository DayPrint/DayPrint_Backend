package multicampus.dayprint_backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
