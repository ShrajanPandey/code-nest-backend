package com.nincompoop.codenest.controllers.Impl;

import com.nincompoop.codenest.constants.BinarySearchConstants;
import com.nincompoop.codenest.controllers.CodeNestController;

import com.nincompoop.codenest.dtos.CodeNestResponse;
import com.nincompoop.codenest.dtos.CodeNestResponse.ResponseData;
import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.SearchFilter;
import com.nincompoop.codenest.service.CodeNestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:44
 */

public class CodeNestControllerImpl implements CodeNestController {

    @Autowired
    CodeNestService codeNestService;

    @Override
    public CodeNestResponse authenticateUser(String username, String password) {
        return null;
    }

    @Override
    public CodeNestResponse getProblemsList(int offset, int limit, SearchFilter searchFilter) {
        try{
            List<ProblemListDTO> problemList = codeNestService.getProblemsList(offset, limit, searchFilter);
            ResponseData data = ResponseData.builder()
                    .problemList(problemList)
                    .build();

            return successResponse(data);
        }
        catch(Exception e){
            return failureResponse();
        }
    }

    @Override
    public CodeNestResponse getProblemDetails(@NonNull int problemId) {
        return null;
    }

    private CodeNestResponse successResponse(@NonNull ResponseData data){
        return CodeNestResponse.builder()
                .statusCode(BinarySearchConstants.SUCCESS_CODE)
                .message(BinarySearchConstants.SUCCESS)
                .data(data).build();
    }

    private CodeNestResponse failureResponse(){
        return CodeNestResponse.builder()
                .statusCode(BinarySearchConstants.ERROR_CODE)
                .message(BinarySearchConstants.ERROR)
                .build();
    }
}
