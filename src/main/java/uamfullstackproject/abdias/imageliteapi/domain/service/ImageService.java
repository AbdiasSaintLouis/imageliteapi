package uamfullstackproject.abdias.imageliteapi.domain.service;

import uamfullstackproject.abdias.imageliteapi.domain.entity.Image;
import uamfullstackproject.abdias.imageliteapi.domain.enums.ImageExtension;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image save(Image image);

    Optional<Image> getById(String id);

    List<Image> search(ImageExtension extension, String query);

}
