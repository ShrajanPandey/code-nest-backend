package com.nincompoop.codenest.dtos;

import com.nincompoop.codenest.constants.CodeNestConstants;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author - shrajan.pandey
 * Sunday 13/04/25
 */

public class CodeNestRequestDTOs {

    @Data
    public static class FetchProblemsRequestDTO {
        SearchFilter searchFilter;
        int offset;
        int limit;
    }

    @Data
    public static class SearchFilter {

        @Nullable
        List<String> difficulty;
        @Nullable
        List<String> concepts;
        @Nullable
        List<String> companies;
        boolean sortByAccepted;
        boolean sortByDifficulty;

    }

    @Data
    public static class JudgeSolutionRequestDTO {
        CodeNestConstants.ACTION action;
        String problemId;
        String typedCode;
        String language;
    }

}
