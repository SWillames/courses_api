package sw_software.courses_api.modules.course.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class CourseAlreadyRegisteredException extends Exception {

  public CourseAlreadyRegisteredException(String courseName) {
    super(String.format("Course %s already registered", courseName));
  }
}
