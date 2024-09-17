package com.nincompoop.codenest.controllers;

import com.nincompoop.codenest.dtos.CodeNestResponse;
import com.nincompoop.codenest.dtos.SearchFilter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:36
 */

@Service
@RequestMapping("/binarysearch")
public interface CodeNestController {

    @GetMapping("/authenticate")
    CodeNestResponse authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password);

    @GetMapping("/getProblemsList")
    CodeNestResponse getProblemsList(@RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                     @RequestParam("searchFilter")SearchFilter searchFilter);

    @GetMapping("/loadProblem")
    CodeNestResponse getProblemDetails(@RequestParam int problemId);

}
