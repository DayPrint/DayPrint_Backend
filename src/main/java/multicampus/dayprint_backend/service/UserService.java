package multicampus.dayprint_backend.service;

import lombok.extern.slf4j.Slf4j;
import multicampus.dayprint_backend.entity.User;
import multicampus.dayprint_backend.repository.UserRepository;
import multicampus.dayprint_backend.repository.PostInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUser(Long id){
        return userRepository.findById(id).orElse(new User());
    }

}
