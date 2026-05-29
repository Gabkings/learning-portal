package com.gabkings.learning_portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "lessons",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name", "course_id"})
        })
@Getter
@Setter
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "video_url", length = 255)
    private String videoUrl;

    @Column(name = "pdf_url", length = 255)
    private String pdfUrl;

    @Column(name = "duration")
    private Integer duration;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
