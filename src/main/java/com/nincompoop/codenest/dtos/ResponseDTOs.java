package com.nincompoop.codenest.dtos;

import com.nincompoop.codenest.constants.CodeNestConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @author - shrajan.pandey
 * Sunday 13/04/25
 */


public class ResponseDTOs {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class JudgeSolutionResponse {
        @Nullable
        CodeNestConstants.RUN_STATUS runStatus;
        @Nullable
        CodeNestConstants.SUBMIT_STATUS submitStatus;
        @Nullable
        ProblemDetails.TestCase failedTestCase;
        int totalTestCasesCount;
        int passedTestCasesCount;
    }

}
