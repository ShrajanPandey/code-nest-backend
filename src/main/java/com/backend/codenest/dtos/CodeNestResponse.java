package com.backend.codenest.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 01:01
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CodeNestResponse {

    @NonNull
    HttpStatus statusCode;
    @NonNull
    String message;
    @Nullable
    ResponseData data;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ResponseData {
        @Nullable
        @JsonProperty("problems_list")
        List<ProblemListDTO> problemList;

        @Nullable
        @JsonProperty("problem_description")
        ProblemDetails problemDetails;

        @Nullable
        @JsonProperty("judge_response")
        ResponseDTOs.JudgeSolutionResponse judgeSolutionResponse;
    }

}
