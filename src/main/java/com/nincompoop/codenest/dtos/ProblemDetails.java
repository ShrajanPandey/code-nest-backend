package com.nincompoop.codenest.dtos;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.List;

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

    @NonNull
    String problemId;

    @NonNull
    String problemTitle;

    @NonNull
    String problemStatement;

    @NonNull
    List<TestCase> testCases;

    @Nullable
    List<String> hints;

    @NonNull
    String hiddenTestCasesId;

    @Nullable
    String author;

    @Nullable
    String functionTemplate;

    @Nullable
    List<String> constraints;

    @Nullable
    List<String> conceptTags;

    @Nullable
    List<String> companies;

    @Nullable
    String difficulty;

    @Nullable // for now null
    int likes;

    @Nullable // for now until added in UI
    int dislikes;

    @Data
    public static class TestCase {
        String input;
        String output;
        String explanation;
    }

}
