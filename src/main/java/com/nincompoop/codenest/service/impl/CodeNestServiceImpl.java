package com.nincompoop.codenest.service.impl;

import com.nincompoop.codenest.dtos.ProblemDetails;
import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.SearchFilter;
import com.nincompoop.codenest.entities.Problems;
import com.nincompoop.codenest.repository.slave.ProblemsSlaveRepository;
import com.nincompoop.codenest.service.CodeNestService;
import com.nincompoop.codenest.service.ProblemsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

        return List.of();

    }

    @Override
    public ProblemDetails fetchProblemDetails(@NonNull String problemId) {

        log.info("Fetching problem details for problemId {}", problemId);

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
        List<String> conceptTags = Arrays.asList(problem.getConceptTags().split(","));

        ProblemDetails problemDetails = new ProblemDetails();

        //parsing problem Description etc. form template and populating the DTO
        parseProblemDescriptionFromTemplate(problemDetails, problemStatementPath, sampleTestCasesPath);

        problemDetails.setProblemTitle(problemName);
        problemDetails.setProblemId(problem.getId());
        problemDetails.setAuthor(problem.getAuthor());
        problemDetails.setDifficulty(problem.getDifficulty());
        problemDetails.setConceptTags(conceptTags);
        problemDetails.setFunctionTemplate(
                "function add(a, b) {\n" +
                "    return a + b;\n" +
                "}"
        );

        return problemDetails;

    }

    void parseProblemDescriptionFromTemplate(ProblemDetails problemDetails, String problemStatementPath, String sampleTestCasesPath) {

        //to be fetched after parsing file from example test cases
        ProblemDetails.ExampleTestCase exampleTestCases1 = new ProblemDetails.ExampleTestCase();
        exampleTestCases1.setInput("nums = [2,7,11,15], target = 9");
        exampleTestCases1.setOutput("[0,1]");
        exampleTestCases1.setExplanation("Because nums[0] + nums[1] == 9, we return [0, 1].");

        ProblemDetails.ExampleTestCase exampleTestCases2 = new ProblemDetails.ExampleTestCase();
        exampleTestCases2.setInput("[3,2,4], target = 6");
        exampleTestCases2.setOutput("[1,2]");

        ProblemDetails.ExampleTestCase exampleTestCases3 = new ProblemDetails.ExampleTestCase();
        exampleTestCases3.setInput("[3,3], target = 6");
        exampleTestCases3.setOutput("[0,1]");


        problemDetails.setProblemStatement("Given an array of integers nums and an integer target, return indices of the " +
                "two numbers such that they add up to target. <br />"
                + "You may assume that each input would have exactly one solution, " +
                "and you may not use the same element twice. <br />"
                + "You can return the answer in any order.<br />");

        problemDetails.setConstraints(List.of("1 <= n <= 1e9", "Only one valid answer exists."));

        problemDetails.setExampleTestCases(List.of(exampleTestCases1, exampleTestCases2, exampleTestCases3));

        problemDetails.setHints(List.of("Shrajan good boy", "Boy boy good good"));

    }

}
