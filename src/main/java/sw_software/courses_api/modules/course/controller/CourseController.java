package sw_software.courses_api.modules.course.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw_software.courses_api.modules.course.dto.CourseRequestDto;
import sw_software.courses_api.modules.course.entity.CourseEntity;
import sw_software.courses_api.modules.course.service.CourseServiceImpl;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseController {

  private final CourseServiceImpl courseService;

  @GetMapping
  public ResponseEntity<List<CourseEntity>> list() {
    return courseService.listCourses();
  }

  @PostMapping
  public ResponseEntity<CourseEntity> create(@RequestBody @Valid CourseRequestDto courseDto) {
    CourseEntity course = new CourseEntity(courseDto);
    return courseService.createCourse(course);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<CourseEntity>> get(@PathVariable Long id) {
    return courseService.course(id);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<CourseEntity> update(@PathVariable Long id, @RequestBody @Valid CourseRequestDto courseDto) {
    CourseEntity course = new CourseEntity(courseDto);
    return courseService.updateCourse(id, course);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    courseService.deleteCourse(id);
  }
}
