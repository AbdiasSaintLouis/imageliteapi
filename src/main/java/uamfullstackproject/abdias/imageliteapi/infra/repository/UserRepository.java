package uamfullstackproject.abdias.imageliteapi.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uamfullstackproject.abdias.imageliteapi.domain.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}