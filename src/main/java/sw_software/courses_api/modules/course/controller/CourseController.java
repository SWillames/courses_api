package sw_software.courses_api.modules.course.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw_software.courses_api.modules.course.entity.CourseEntity;
import sw_software.courses_api.modules.course.service.CourseServiceImpl;

import java.util.List;

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
  public ResponseEntity<CourseEntity> create(@RequestBody CourseEntity course) {
    return courseService.createCourse(course);
  }
}
