package sw_software.courses_api.modules.course.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sw_software.courses_api.modules.course.entity.CourseEntity;
import sw_software.courses_api.modules.course.repository.CourseRepository;

import java.util.List;

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
}
