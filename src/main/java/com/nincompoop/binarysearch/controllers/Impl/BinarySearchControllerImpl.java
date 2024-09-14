package com.nincompoop.binarysearch.controllers.Impl;

import com.nincompoop.binarysearch.constants.BinarySearchConstants;
import com.nincompoop.binarysearch.controllers.BinarySearchController;

import com.nincompoop.binarysearch.dtos.BinarySearchResponse;
import com.nincompoop.binarysearch.dtos.BinarySearchResponse.ResponseData;
import com.nincompoop.binarysearch.dtos.ProblemListDTO;
import com.nincompoop.binarysearch.dtos.SearchFilter;
import com.nincompoop.binarysearch.service.BinarySearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:44
 */

public class BinarySearchControllerImpl implements BinarySearchController {

    @Autowired
    BinarySearchService binarySearchService;

    @Override
    public BinarySearchResponse authenticateUser(String username, String password) {
        return null;
    }

    @Override
    public BinarySearchResponse getProblemsList(int offset, int limit, SearchFilter searchFilter) {
        try{
            List<ProblemListDTO> problemList = binarySearchService.getProblemsList(offset, limit, searchFilter);
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
    public BinarySearchResponse getProblemDetails(@NonNull int problemId) {
        return null;
    }

    private BinarySearchResponse successResponse(@NonNull ResponseData data){
        return BinarySearchResponse.builder()
                .statusCode(BinarySearchConstants.SUCCESS_CODE)
                .message(BinarySearchConstants.SUCCESS)
                .data(data).build();
    }

    private BinarySearchResponse failureResponse(){
        return BinarySearchResponse.builder()
                .statusCode(BinarySearchConstants.ERROR_CODE)
                .message(BinarySearchConstants.ERROR)
                .build();
    }
}
