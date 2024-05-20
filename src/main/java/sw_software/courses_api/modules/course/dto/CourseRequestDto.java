package sw_software.courses_api.modules.course.dto;

import jakarta.validation.constraints.NotNull;
import sw_software.courses_api.modules.course.enums.Active;

public record CourseRequestDto(
    @NotNull
    String name,
    @NotNull
    String category,
    @NotNull
    Active active
) {
}
