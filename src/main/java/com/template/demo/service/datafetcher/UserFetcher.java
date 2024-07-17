package com.template.demo.service.datafetcher;

import com.template.demo.entity.User;
import com.template.demo.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFetcher implements DataFetcher<User>{

    @Autowired
    UserRepository userRepository;

    @Override
    public User get(DataFetchingEnvironment dataFetchingEnvironment) {

        Long id = dataFetchingEnvironment.getArgument("id");

        return userRepository.findById(id).get();
    }
}
