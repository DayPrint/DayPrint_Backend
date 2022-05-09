package multicampus.dayprint_backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class CommentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private PostInfo postInfo;

    private String author;

    private String text;
}
