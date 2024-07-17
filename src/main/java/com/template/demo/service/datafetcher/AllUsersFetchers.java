package com.template.demo.service.datafetcher;

import com.template.demo.entity.User;
import com.template.demo.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AllUsersFetchers implements DataFetcher<List<User>>{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return userRepository.findAll();
    }
}
