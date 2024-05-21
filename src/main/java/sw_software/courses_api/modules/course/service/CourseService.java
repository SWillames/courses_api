package sw_software.courses_api.modules.course.service;

import org.springframework.http.ResponseEntity;
import sw_software.courses_api.modules.course.entity.CourseEntity;
import sw_software.courses_api.modules.course.exceptions.CourseAlreadyRegisteredException;

import java.util.List;
import java.util.Optional;

public interface CourseService {

  public CourseEntity createCourse(CourseEntity course) throws CourseAlreadyRegisteredException;

  public ResponseEntity<List<CourseEntity>> listCourses();

  public CourseEntity course(Long id);

  public ResponseEntity<CourseEntity> updateCourse(Long id, CourseEntity course) throws CourseAlreadyRegisteredException;

  public void deleteCourse(Long id);
}
