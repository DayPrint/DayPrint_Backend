package multicampus.dayprint_backend.repository;

import multicampus.dayprint_backend.entity.CommentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentInfoRepository extends JpaRepository<CommentInfo,Long> {
}
