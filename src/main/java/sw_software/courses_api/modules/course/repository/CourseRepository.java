package sw_software.courses_api.modules.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sw_software.courses_api.modules.course.entity.CourseEntity;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {

  Optional<CourseEntity> findByName(String name);
}
