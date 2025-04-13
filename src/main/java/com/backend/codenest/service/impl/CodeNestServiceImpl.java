package com.backend.codenest.service.impl;

import com.backend.codenest.constants.CodeNestConstants;
import com.backend.codenest.dtos.CodeNestRequestDTOs;
import com.backend.codenest.dtos.ProblemDetails;
import com.backend.codenest.dtos.ProblemListDTO;
import com.backend.codenest.dtos.ResponseDTOs;
import com.backend.codenest.entities.Problem;
import com.backend.codenest.repository.slave.ProblemSlaveRepository;
import com.backend.codenest.service.CodeNestService;
import com.backend.codenest.service.ProblemsManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
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
    ProblemSlaveRepository problemSlaveRepository;

    @Autowired
    ProblemsManager problemsManager;

    @Override
    public List<ProblemListDTO> fetchProblemsList(@NonNull CodeNestRequestDTOs.FetchProblemsRequestDTO fetchProblemsRequestDTO) {

        List<Problem> problemList = problemSlaveRepository.getProblemsList(0, fetchProblemsRequestDTO.getLimit());
        applySearchFilter(problemList, fetchProblemsRequestDTO.getSearchFilter());

        return problemList.stream()
                .map(problem -> ProblemListDTO.builder()
                        .problemName(problem.getProblemName())
                        .problemId(problem.getId())
                        .difficulty(problem.getDifficulty())
                        .accepted(problem.getAcceptedCount())
                        .submission(problem.getSubmissionCount())
                        .build())
                .toList();

    }

    @Override
    public ProblemDetails fetchProblemDetails(@NonNull String problemId) {

        log.info("Fetching problem details for problemId {}", problemId);

        Problem problem = problemSlaveRepository.findById(problemId).orElse(null);

        if(Objects.isNull(problem)) {
            String errorMessage = "Invalid problem " + problemId;
            log.error(errorMessage);
            throw new RuntimeException(errorMessage);
        }

        return generateProblemDetailsDTO(problem);

    }

    @Override
    public ResponseDTOs.JudgeSolutionResponse judgeSolution(@NonNull CodeNestRequestDTOs.JudgeSolutionRequestDTO judgeSolutionRequestDTO) {
        log.info(" Request to judge solution received ---> {}", judgeSolutionRequestDTO);
        // Logic for running the code yet to be figured out
        // current idea
        // add the typed code in a new file
        // write a base template code which uses the file class to run it
        // thus always having a constant form
        return ResponseDTOs.JudgeSolutionResponse.builder()
                .runStatus(CodeNestConstants.RUN_STATUS.CORRECT)
                .totalTestCasesCount(10)
                .passedTestCasesCount(10)
                .build();
    }

    private ProblemDetails generateProblemDetailsDTO(@NonNull Problem problem) {

        String problemName = problem.getProblemName();
        String problemStatementPath = problem.getProblemStatement();
        String sampleTestCasesPath = problem.getSampleTestCases();
        List<String> conceptTags = Arrays.asList(problem.getConceptTags().split(","));

        ProblemDetails problemDetails = new ProblemDetails();

        //parsing problem Description etc. from template and populating the DTO
        parseProblemDescriptionFromTemplate(problemDetails, problemStatementPath, sampleTestCasesPath);

        problemDetails.setProblemTitle(problemName);
        problemDetails.setProblemId(problem.getId());
        problemDetails.setAuthor(problem.getAuthor());
        problemDetails.setDifficulty(problem.getDifficulty());
        problemDetails.setConceptTags(conceptTags);
        problemDetails.setFunctionTemplate( // TODO-SHRAJAN think about logic to fetch template of question
                "function add(a, b) {\n" +
                "    return a + b;\n" +
                "}"
        );

        return problemDetails;

    }

    private void parseProblemDescriptionFromTemplate(ProblemDetails problemDetails, String problemStatementPath, String sampleTestCasesPath) {

        //to be fetched after parsing file from example test cases
        ProblemDetails.TestCase testCase1 = new ProblemDetails.TestCase();
        testCase1.setInput("nums = [2,7,11,15], target = 9");
        testCase1.setOutput("[0,1]");
        testCase1.setExplanation("Because nums[0] + nums[1] == 9, we return [0, 1].");

        ProblemDetails.TestCase testCase2 = new ProblemDetails.TestCase();
        testCase2.setInput("[3,2,4], target = 6");
        testCase2.setOutput("[1,2]");

        ProblemDetails.TestCase testCase3 = new ProblemDetails.TestCase();
        testCase3.setInput("[3,3], target = 6");
        testCase3.setOutput("[0,1]");


        problemDetails.setProblemStatement("Given an array of integers nums and an integer target, return indices of the " +
                "two numbers such that they add up to target. <br />"
                + "You may assume that each input would have exactly one solution, " +
                "and you may not use the same element twice. <br />"
                + "You can return the answer in any order.<br />");

        problemDetails.setConstraints(List.of("1 <= n <= 1e9", "Only one valid answer exists."));

        problemDetails.setTestCases(List.of(testCase1, testCase2, testCase3));

        problemDetails.setHints(List.of("Shrajan good boy", "Boy boy good good"));

    }

    private void applySearchFilter(@Nullable List<Problem> problemList, @Nullable CodeNestRequestDTOs.SearchFilter searchFilter) {

        //if problemsList is null or searchFilter is null there's nothing to filter
        if(Objects.isNull(problemList) || Objects.isNull(searchFilter)) {
            return;
        }

        problemList.stream().filter((problem -> problem.getCompanies().contains(searchFilter.getCompanies().get(0)))).toList();

        if(searchFilter.isSortByAccepted()) {
            problemList.sort(Comparator.comparing(Problem::getSubmissionCount));
        }

        if(searchFilter.isSortByDifficulty()) {
            problemList.sort(Comparator.comparing(Problem::getDifficulty));
        }

    }

}
