package com.template.demo.service.impl;

import com.template.demo.entity.User;
import com.template.demo.exception.UserException;
import com.template.demo.repository.UserRepository;
import com.template.demo.service.UserService;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@GraphQLApi
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @GraphQLQuery(name = "users")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    @GraphQLQuery(name = "user")
    public User getById(@GraphQLArgument(name = "id") Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new UserException(404, "User with id " + id + " cannot be found");
        }
        return user.get();
    }

    @Override
    @GraphQLMutation(name= "saveUser")
    public User create(@GraphQLArgument(name = "user") User user) {
        return userRepository.save(user);
    }

    @Override
    @GraphQLMutation(name= "updateUser")
    public User update(@GraphQLArgument(name = "id") Long id,
                       @GraphQLArgument(name = "username") String username,
                       @GraphQLArgument(name = "email") String email) {
        User user = getById(id);
        user.updateFields(username, email);
        return userRepository.save(user);
    }

    @Override
    @GraphQLMutation(name= "deleteUser")
    public boolean delete(@GraphQLArgument(name = "id") Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return true;
    }
}
