package com.backend.codenest.controllers;

import com.backend.codenest.dtos.*;
import com.backend.codenest.dtos.CodeNestResponse.ResponseData;
import com.backend.codenest.service.CodeNestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:36
 */

@CrossOrigin(origins = "*")
@RestController
public class CodeNestController {

    @Autowired
    CodeNestService codeNestService;

    @GetMapping("/authenticate")
    CodeNestResponse authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return null;
    }

    @GetMapping(value = "/fetchProblemsList", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CodeNestResponse fetchProblemsList(@RequestBody CodeNestRequestDTOs.FetchProblemsRequestDTO fetchProblemsRequestDTO){
        try{
            List<ProblemListDTO> problemList = codeNestService.fetchProblemsList(fetchProblemsRequestDTO);
            ResponseData data = ResponseData.builder()
                    .problemList(problemList)
                    .build();

            return successResponse(data);
        }
        catch(Exception e){
            return failureResponse(e.getMessage());
        }
    }

    @GetMapping(value = "/fetchProblemDescription", produces = MediaType.APPLICATION_JSON_VALUE)
    CodeNestResponse fetchProblemDescription(@RequestParam("problemId") String problemId){

        try{
            ProblemDetails problemDetails = codeNestService.fetchProblemDetails(problemId);
            ResponseData data = ResponseData.builder()
                    .problemDetails(problemDetails)
                    .build();

            return successResponse(data);
        }
        catch(Exception e){
            return failureResponse(e.getMessage());
        }

    }

    @PostMapping(value = "/judgeSolution", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CodeNestResponse judgeSolution(@RequestBody CodeNestRequestDTOs.JudgeSolutionRequestDTO judgeSolutionRequestDTO) {

        try {
            ResponseDTOs.JudgeSolutionResponse judgeSolutionResponse = codeNestService.judgeSolution(judgeSolutionRequestDTO);
            ResponseData data = ResponseData.builder()
                    .judgeSolutionResponse(judgeSolutionResponse)
                    .build();

            return successResponse(data);
        }
        catch (Exception e) {
            return failureResponse(e.getMessage());
        }

    }

    private CodeNestResponse successResponse(@NonNull ResponseData data){
        return CodeNestResponse.builder()
                .statusCode(HttpStatus.OK)
                .message("SUCCESS")
                .data(data).build();
    }

    private CodeNestResponse failureResponse(@Nullable String message){
        return CodeNestResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(message)
                .build();
    }

}
