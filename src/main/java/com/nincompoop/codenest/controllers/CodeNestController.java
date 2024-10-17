package com.nincompoop.codenest.controllers;

import com.nincompoop.codenest.constants.CodeNestConstants;
import com.nincompoop.codenest.dtos.CodeNestResponse;
import com.nincompoop.codenest.dtos.CodeNestResponse.ResponseData;
import com.nincompoop.codenest.dtos.ProblemDetails;
import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.SearchFilter;
import com.nincompoop.codenest.service.CodeNestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:36
 */

@Controller
public class CodeNestController {

    @Autowired
    CodeNestService codeNestService;

    @GetMapping("/authenticate")
    CodeNestResponse authenticateUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return null;
    }

    @GetMapping("/fetchProblemsList")
    CodeNestResponse fetchProblemsList(@RequestBody int offset, @RequestBody int limit,
                                     @RequestParam("searchFilter")SearchFilter searchFilter){
        try{
            List<ProblemListDTO> problemList = codeNestService.fetchProblemsList(offset, limit, searchFilter);
            ResponseData data = ResponseData.builder()
                    .problemList(problemList)
                    .build();

            return successResponse(data);
        }
        catch(Exception e){
            return failureResponse(e.getMessage());
        }
    }

    @GetMapping("/loadProblem")
    CodeNestResponse loadProblem(){

        try{
            ProblemDetails problemDetails = codeNestService.loadProblemDetails("");
            ResponseData data = ResponseData.builder()
                    .problemDetails(problemDetails)
                    .build();

            return successResponse(data);
        }
        catch(Exception e){
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
                .statusCode(HttpStatus.BAD_REQUEST)
                .message(message)
                .build();
    }

}
