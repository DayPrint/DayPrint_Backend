package multicampus.dayprint_backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class PostInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String title;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime targetDate;

    private String postContent;

    @OneToMany
    @JoinColumn(name = "postinfo_id")
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
