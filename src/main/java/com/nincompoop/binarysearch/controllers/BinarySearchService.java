package com.nincompoop.binarysearch.controllers;

import com.nincompoop.binarysearch.dtos.BinarySearchResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Shrajan
 * -- 04 04-09-2024 09 2024
 * -- 00:36
 */

@Service
@RequestMapping("/binarysearch")
public interface BinarySearchService {

    @GetMapping("/authenticate")
    BinarySearchResponse authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password);

    @GetMapping("/getProblemsList")
    BinarySearchResponse getProblemsList(@RequestParam("page") int page,
                                         @RequestParam("pageLimit") int pageLimit,
                                         @RequestParam("searchFilter") String searchFilter);

    @GetMapping("/loadProblem")
    BinarySearchResponse getProblemDetails(@RequestParam int problemId);

}
