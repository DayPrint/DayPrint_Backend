package multicampus.dayprint_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data
@Entity
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String phone;

    @Column(unique = true)
    @Email
    private String email;

    @Column
    private String password;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonIgnore
    private List<PostInfo> postInfos=new ArrayList<>();

    public void addPost(PostInfo postInfo){
        postInfos.add(postInfo);
    }
    public void removePost(PostInfo postInfo){
        postInfos.remove(postInfo);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
