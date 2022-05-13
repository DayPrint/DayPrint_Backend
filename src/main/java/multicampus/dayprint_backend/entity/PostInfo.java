package multicampus.dayprint_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class PostInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private User user;

    @Column
    private String title;

    @Column
    private String postContent;

    @Column
    private String imageUrl;

    @Column
    private String theme;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate targetDate;

    @OneToMany
    @JoinColumn(name = "post_info_id")
    @ToString.Exclude
    @JsonIgnore
    private List<CommentInfo> commentInfos = new ArrayList<>();

    public void addComment(CommentInfo commentInfo){
        commentInfos.add(commentInfo);
    }
    public void removeComment(CommentInfo commentInfo){
        commentInfos.remove(commentInfo);
    }
}
