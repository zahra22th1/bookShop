package org.example.bookshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = SchemaName.SchemaName)
public class User extends BaseEntity {
    private String username;
    private String password;

}
