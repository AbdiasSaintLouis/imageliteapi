package uamfullstackproject.abdias.imageliteapi.infra.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.util.StringUtils;
import uamfullstackproject.abdias.imageliteapi.domain.entity.Image;
import uamfullstackproject.abdias.imageliteapi.domain.enums.ImageExtension;
import uamfullstackproject.abdias.imageliteapi.infra.repository.specs.GenericSpecs;
import uamfullstackproject.abdias.imageliteapi.infra.repository.specs.ImageSpecs;

import java.util.List;

import static uamfullstackproject.abdias.imageliteapi.infra.repository.specs.ImageSpecs.nameLike;
import static uamfullstackproject.abdias.imageliteapi.infra.repository.specs.ImageSpecs.tagsLike;

public interface ImageRepository extends JpaRepository<Image, String>, JpaSpecificationExecutor<Image> {

    default List<Image> findByExtensionAndNameOrTagsLike( ImageExtension extension, String query ){
        Specification<Image> spec = Specification.where(GenericSpecs.conjunction());

            if(extension != null){
            spec = spec.and(ImageSpecs.extensionEqual(extension));
            // add in query
        }

        if (StringUtils.hasText(query)) {
            spec = spec.and(Specification.anyOf(nameLike(query), tagsLike(query)));
        }

        return findAll();

    }
}
