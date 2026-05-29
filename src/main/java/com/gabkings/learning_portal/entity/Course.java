package com.gabkings.learning_portal.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(
        name = "courses",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"title", "category_id"})
        }
)
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "id")
    private User instructor;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "course", cascade = {CascadeType.REMOVE})
    private List<Lesson> lessons;
}
