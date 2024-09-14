package com.nincompoop.binarysearch.controllers;

import com.nincompoop.binarysearch.dtos.BinarySearchResponse;
import com.nincompoop.binarysearch.dtos.SearchFilter;
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
public interface BinarySearchController {

    @GetMapping("/authenticate")
    BinarySearchResponse authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password);

    @GetMapping("/getProblemsList")
    BinarySearchResponse getProblemsList(@RequestParam("offset") int offset, @RequestParam("limit") int limit,
                                         @RequestParam("searchFilter")SearchFilter searchFilter);

    @GetMapping("/loadProblem")
    BinarySearchResponse getProblemDetails(@RequestParam int problemId);

}
