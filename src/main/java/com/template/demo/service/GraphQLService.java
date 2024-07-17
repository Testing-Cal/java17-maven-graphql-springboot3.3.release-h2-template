package com.template.demo.service;

import com.template.demo.service.datafetcher.AllUsersFetchers;
import com.template.demo.service.datafetcher.UserFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;

@Service
public class GraphQLService {

    @Autowired
    UserService userService;

    private GraphQL graphQL;

    @Autowired
    private AllUsersFetchers allUsersFetchers;

    @Autowired
    private UserFetcher userFetcher;

    // load schema at application start up
    @PostConstruct
    private void loadSchema() throws IOException {
        GraphQLSchema schema = new GraphQLSchemaGenerator().withOperationsFromSingleton(userService).generate();
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }
}
