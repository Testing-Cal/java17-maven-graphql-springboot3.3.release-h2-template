package com.template.demo.service;

import com.template.demo.entity.User;
import io.leangen.graphql.annotations.GraphQLArgument;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User create(@GraphQLArgument(name = "user") User user);

    User update(Long id, String username, String email);

    boolean delete(Long id);
}
