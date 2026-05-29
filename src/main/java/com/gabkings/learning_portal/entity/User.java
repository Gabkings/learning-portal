package com.gabkings.learning_portal.entity;

import com.gabkings.learning_portal.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@Getter
@Setter
public class User { // implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", length = 150, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 150)
    private String lastName;

    @Column(name = "username", length = 150, nullable = false)
    private String username;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;

    // role - STUDENT, INSTRUCTOR, ADMIN
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "instructor", cascade = {CascadeType.REMOVE})
    private List<Course> courses;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));
//
//        return grantedAuthorities;
//    }
}
