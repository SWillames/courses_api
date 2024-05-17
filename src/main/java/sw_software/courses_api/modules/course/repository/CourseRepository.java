package sw_software.courses_api.modules.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sw_software.courses_api.modules.course.entity.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
}
