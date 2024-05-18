package sw_software.courses_api.modules.course.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sw_software.courses_api.modules.course.entity.CourseEntity;
import sw_software.courses_api.modules.course.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  @Autowired
  private final CourseRepository courseRepository;

  @Override
  public ResponseEntity<CourseEntity> createCourse(CourseEntity course) {
    var result = courseRepository.save(course);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<List<CourseEntity>> listCourses() {
    var result = courseRepository.findAll();
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Optional<CourseEntity>> course(Long id) {
    var result = courseRepository.findById(id);
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<CourseEntity> updateCourse(Long id, CourseEntity course) {
    Optional<CourseEntity> courseEntity = courseRepository.findById(id);
    if (courseEntity.isPresent()) {
      CourseEntity updatedCourse = courseEntity.get();
      updatedCourse.setName(course.getName());
      updatedCourse.setCategory(course.getCategory());
      updatedCourse.setActive(course.getActive());
      return ResponseEntity.ok(courseRepository.save(updatedCourse));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }
}
