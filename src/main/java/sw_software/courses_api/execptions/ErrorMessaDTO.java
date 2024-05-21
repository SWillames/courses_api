package sw_software.courses_api.execptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessaDTO {

  private String message;
  private String field;
}
