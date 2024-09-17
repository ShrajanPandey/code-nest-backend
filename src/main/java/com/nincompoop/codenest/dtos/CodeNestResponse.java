package com.nincompoop.codenest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    String statusCode;
    @NonNull
    String message;
    @Nullable
    ResponseData data;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseData {
        @Nullable
        List<ProblemListDTO> problemList;
    }

}
