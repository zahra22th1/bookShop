package org.example.bookshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;


@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLRestriction("deleted is null")
@SQLDelete(sql = "update shop.book set deleted = now() where id = ?")
public class Book extends BaseEntity{
private String name;
private long price;
}
