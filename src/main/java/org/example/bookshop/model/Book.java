package org.example.bookshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = SchemaName.SchemaName)
public class Book extends BaseEntity{
private String name;
private long price;
}
