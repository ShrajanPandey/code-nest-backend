package com.nincompoop.codenest.service;

import com.nincompoop.codenest.dtos.CodeNestRequestDTOs;
import com.nincompoop.codenest.dtos.ProblemDetails;
import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.ResponseDTOs;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

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
