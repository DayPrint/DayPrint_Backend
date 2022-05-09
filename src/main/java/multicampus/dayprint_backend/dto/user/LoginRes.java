package multicampus.dayprint_backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRes {

    private Long id;

    private String jwtToken;
}
