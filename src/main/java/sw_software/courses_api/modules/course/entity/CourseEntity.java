package sw_software.courses_api.modules.course.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import sw_software.courses_api.modules.course.dto.CourseRequestDto;
import sw_software.courses_api.modules.course.enums.Active;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false)
  private String category;
  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Active active;
  @CreationTimestamp
  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;

  public CourseEntity(CourseRequestDto courseDto) {
    this.name = courseDto.name();
    this.category = courseDto.category();
    this.active = courseDto.active();
  }
}
