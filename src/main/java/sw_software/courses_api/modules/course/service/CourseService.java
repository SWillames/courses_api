package sw_software.courses_api.modules.course.service;

import org.springframework.http.ResponseEntity;
import sw_software.courses_api.modules.course.entity.CourseEntity;

import java.util.List;

public interface CourseService {

  public ResponseEntity<CourseEntity> createCourse(CourseEntity course);

  public ResponseEntity<List<CourseEntity>> listCourses();
}
