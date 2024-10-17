package com.nincompoop.codenest.service.impl;

import com.nincompoop.codenest.dtos.ProblemDetails;
import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.SearchFilter;
import com.nincompoop.codenest.models.Problems;
import com.nincompoop.codenest.repository.slave.ProblemsSlaveRepository;
import com.nincompoop.codenest.service.CodeNestService;
import com.nincompoop.codenest.service.ProblemsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Objects;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:03
 */

@Slf4j
@Service
public class CodeNestServiceImpl implements CodeNestService {

    @Autowired
    ProblemsSlaveRepository problemsSlaveRepository;

    @Autowired
    ProblemsManager problemsManager;

    @Override
    public List<ProblemListDTO> fetchProblemsList(@NonNull int offset, @NonNull int limit, @Nullable SearchFilter searchFilter) {

//        List<Problems> problems = problemsSlaveRepository.getProblemsList(offset, limit);

//        return problems.stream().map(problem -> ProblemListDTO.builder()
//                .problemName(problem.getProblemName())
//                .submission(problem.getSubmissionCount())
//                .difficulty(problem.getDifficulty())
//                .problemId(problem.getId())
//                .build()).toList();

        return List.of();

    }


    @Override
    public ProblemDetails loadProblemDetails(@NonNull String problemId) {

        Problems problem = problemsSlaveRepository.findById(problemId).orElse(null);

        if(Objects.isNull(problem)) {
            String errorMessage = "Problem with id " + problemId + " not found";
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        return generateProblemDetailsDTO(problem);

    }

    public ProblemDetails generateProblemDetailsDTO(@NonNull Problems problem) {

        String problemName = problem.getProblemName();
        String problemStatementPath = problem.getProblemStatementPath();
        String sampleTestCasesPath = problem.getSampleTestCasesPath();

        //fetching problem details from files here + generating ExampleTestCases DTO and returning DetailsDTO

        return ProblemDetails.builder()
                .id(problem.getId())
                .problemStatement(problemStatementPath)
                .hiddenTestCasesId(problem.getHiddenTestCasesPath())
                .author(problem.getAuthor())
                .exampleTestCases(new ProblemDetails.ExampleTestCase())
                .build();

    }

}
