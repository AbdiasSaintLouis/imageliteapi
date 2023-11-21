package uamfullstackproject.abdias.imageliteapi.application.users;


import org.springframework.stereotype.Component;
import uamfullstackproject.abdias.imageliteapi.domain.entity.User;

@Component
public class UserMapper {

    public User mapToUser(UserDTO dto){
        return User.builder()
                .email(dto.getEmail())
                .name(dto.getName())
                .password(dto.getPassword())
                .build();
    }
}