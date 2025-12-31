package org.example.bookshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;

@CreatedDate
@Column(updatable=false)
private LocalDateTime createdAt;
@UpdateTimestamp
private LocalDateTime updatedAt;
private LocalDateTime deleted;
}
