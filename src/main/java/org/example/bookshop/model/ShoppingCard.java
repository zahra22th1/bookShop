package org.example.bookshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = SchemaName.SchemaName)
public class ShoppingCard extends BaseEntity {
private int count;
@ManyToOne
private Book book;
@ManyToOne
private Factor factor;

}
