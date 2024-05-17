package sw_software.courses_api.modules.course.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Active {

  ACTIVE("active"),
  INACTIVE("inactive");

  private final String description;
}
