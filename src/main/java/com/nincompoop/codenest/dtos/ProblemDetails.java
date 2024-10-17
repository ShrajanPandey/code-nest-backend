package com.nincompoop.codenest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:31
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemDetails {

    String id;
    String problemStatement;
    ExampleTestCase exampleTestCases;
    String hiddenTestCasesId;
    String author;
    String functionTemplate;
    int likes;


    @Data
    public static class ExampleTestCase {
        String input;
        String output;
        String explanation;
    }

}
