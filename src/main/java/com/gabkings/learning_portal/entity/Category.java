package com.gabkings.learning_portal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(
        name = "categories",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        })
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @OneToMany(cascade = {CascadeType.REMOVE}, mappedBy = "category")
    private List<Course> courses;
}
