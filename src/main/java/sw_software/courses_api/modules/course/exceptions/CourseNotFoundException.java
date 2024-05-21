package sw_software.courses_api.modules.course.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException {

  public CourseNotFoundException(Long id) {
    super(String.format("Course %s not found", id));
  }

}
