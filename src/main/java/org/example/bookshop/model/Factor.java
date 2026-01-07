package org.example.bookshop.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Factor extends BaseEntity {
@ManyToOne
    private User user;
@Enumerated(EnumType.STRING)
    private Paid paid;

}
