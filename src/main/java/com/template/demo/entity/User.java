package com.template.demo.entity;

import io.leangen.graphql.annotations.GraphQLQuery;
import jakarta.validation.constraints.NotBlank;
import lombok.ToString;

import jakarta.persistence.*;


@Table(name = "users")
@Entity
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GraphQLQuery(name = "id", description = "A User's id")
    private Long id;

    @NotBlank
    @Column(unique = true)
    @GraphQLQuery(name = "username", description = "A username")
    private String username;

    @NotBlank
    @Column(unique = true)
    private String email;

    public User() {
    }

    public static User create(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        return user;
    }

    public User updateFields(String username, String email) {
        if (username != null)
            setUsername(username);
        if (email != null)
            setEmail(email);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
