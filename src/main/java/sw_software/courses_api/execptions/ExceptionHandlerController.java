package sw_software.courses_api.execptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

  private MessageSource messageSource;

  public ExceptionHandlerController(MessageSource message) {
    this.messageSource = message;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessaDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    List<ErrorMessaDTO> errors = new ArrayList<>();
    ex.getBindingResult().getFieldErrors().forEach((error) -> {
      String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());
      ErrorMessaDTO errorDTO = new ErrorMessaDTO(error.getField(), message);
      errors.add(errorDTO);
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
}
