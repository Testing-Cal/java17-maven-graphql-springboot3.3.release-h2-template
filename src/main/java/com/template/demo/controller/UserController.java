package com.template.demo.controller;

import com.template.demo.service.GraphQLService;
import com.template.demo.service.UserService;
import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RequestMapping(value = "/rest-graphql")
@RestController
public class UserController {

    @Autowired
    GraphQLService graphQLService;

    @Autowired
    UserService userService;

    /*
     * Rest Only
     */
    @GetMapping("/restGetAllUsers")
    public ResponseEntity<Object> restGetAllUsers() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /*
    * Rest with GraphQL
    */
    @PostMapping("/usersCrud")
    public ResponseEntity<Object> usersCrud(@RequestBody String query) {
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        // ExecutionResult will return data, errors, specifications and extensions
        return new ResponseEntity<>((LinkedHashMap)execute.getData(), HttpStatus.OK);
    }

}
