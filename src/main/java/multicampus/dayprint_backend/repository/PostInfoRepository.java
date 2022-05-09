package multicampus.dayprint_backend.repository;

import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.entity.PostInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostInfoRepository extends JpaRepository<PostInfo,Long> {
    public List<PostInfo> findByUser(User user);
}
