package sw_software.courses_api.modules.course.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import sw_software.courses_api.modules.course.entity.CourseEntity;
import sw_software.courses_api.modules.course.exceptions.CourseAlreadyRegisteredException;
import sw_software.courses_api.modules.course.exceptions.CourseNotFoundException;
import sw_software.courses_api.modules.course.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

  @Autowired
  private final CourseRepository courseRepository;

  @Override
  public CourseEntity createCourse(CourseEntity course) throws CourseAlreadyRegisteredException {
    verifyIfIsAlreadyRegistered(course.getName());
    var result = courseRepository.save(course);
    return result;
  }

  @Override
  public ResponseEntity<List<CourseEntity>> listCourses() {
    var result = courseRepository.findAll();
    return ResponseEntity.ok(result);
  }

  @Override
  public CourseEntity course(Long id) throws CourseNotFoundException {
    CourseEntity foundCourse = verifyIfExists(id);
    return foundCourse;
  }

  @Override
  public ResponseEntity<CourseEntity> updateCourse(Long id, CourseEntity course) throws CourseAlreadyRegisteredException {
    CourseEntity courseEntity = verifyIfExists(id);
    System.out.println(course.getName());
    verifyIfIsAlreadyRegistered(course.getName());
    courseEntity.setName(course.getName());
    courseEntity.setCategory(course.getCategory());
    courseEntity.setActive(course.getActive());
    var result = courseRepository.save(courseEntity);
    return ResponseEntity.ok(result);
  }

  @Override
  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }

  private void verifyIfIsAlreadyRegistered(String name) throws CourseAlreadyRegisteredException {
    Optional<CourseEntity> optSavedCourse = courseRepository.findByName(name);
    if (optSavedCourse.isPresent()) {
      throw new CourseAlreadyRegisteredException(name);
    }
  }

  private CourseEntity verifyIfExists(Long id) throws CourseNotFoundException{
    return courseRepository.findById(id).orElseThrow(() -> new CourseNotFoundException(id));
  }
}
