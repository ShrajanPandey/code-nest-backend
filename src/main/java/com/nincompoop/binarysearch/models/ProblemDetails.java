package com.nincompoop.binarysearch.models;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Created by Shrajan
 * -- Wednesday 04-09-2024
 * -- 00:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problem_details")
public class ProblemDetails {

    int id;
    String problemStatement;
    ExampleTestCase exampleTestCases;
    LocalDateTime dateCreated;
    LocalDateTime dateModified;

    @Data
    static class ExampleTestCase {
        String input;
        String output;
        String explanation;
    }

}
