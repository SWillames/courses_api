package sw_software.courses_api.modules.course.service;

import org.springframework.http.ResponseEntity;
import sw_software.courses_api.modules.course.entity.CourseEntity;

import java.util.List;
import java.util.Optional;

public interface CourseService {

  public ResponseEntity<CourseEntity> createCourse(CourseEntity course);

  public ResponseEntity<List<CourseEntity>> listCourses();

  public ResponseEntity<Optional<CourseEntity>> course(Long id);

  public ResponseEntity<CourseEntity> updateCourse(Long id, CourseEntity course);

  public void deleteCourse(Long id);
}
