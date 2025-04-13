package com.backend.codenest.service;

import com.backend.codenest.dtos.CodeNestRequestDTOs;
import com.backend.codenest.dtos.ProblemDetails;
import com.backend.codenest.dtos.ProblemListDTO;
import com.backend.codenest.dtos.ResponseDTOs;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:03
 */

public interface CodeNestService {

    List<ProblemListDTO> fetchProblemsList(CodeNestRequestDTOs.FetchProblemsRequestDTO fetchProblemsRequestDTO);

    ProblemDetails fetchProblemDetails(@NonNull String problemId);

    ResponseDTOs.JudgeSolutionResponse judgeSolution(CodeNestRequestDTOs.JudgeSolutionRequestDTO judgeSolutionRequestDTO);

}
