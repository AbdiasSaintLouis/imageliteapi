package uamfullstackproject.abdias.imageliteapi.domain.service;

import uamfullstackproject.abdias.imageliteapi.domain.AccessToken;
import uamfullstackproject.abdias.imageliteapi.domain.entity.User;

public interface UserService {
   User getByEmail( String email);
    User save(User user);
    AccessToken authenticate( String email, String password);
}
