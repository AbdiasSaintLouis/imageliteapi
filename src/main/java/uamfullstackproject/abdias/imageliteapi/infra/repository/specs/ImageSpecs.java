package uamfullstackproject.abdias.imageliteapi.infra.repository.specs;

import org.springframework.data.jpa.domain.Specification;
import uamfullstackproject.abdias.imageliteapi.domain.entity.Image;
import uamfullstackproject.abdias.imageliteapi.domain.enums.ImageExtension;

public class ImageSpecs {

    private ImageSpecs(){}

    public  static Specification<Image> extensionEqual( ImageExtension extension){
        return (root, q, cb) -> cb.equal(root.get("extension"), extension);
    }

    public  static Specification<Image> nameLike(String name){
        return (root, q, cb) -> cb.like( cb.upper(root.get("name")), "%" + name.toUpperCase() + "%");
    }

    public  static Specification<Image> tagsLike(String tags){
        return (root, q, cb) -> cb.like( cb.upper(root.get("name")), "%" + tags.toUpperCase() + "%");
    }
}
