package com.nincompoop.binarysearch.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Shrajan
 * -- Wednesday 04-09-2024
 * -- 01:01
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BinarySearchResponse {

    String statusCode;
    String message;
    ResponseData data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class ResponseData {
        String id;
        //ALl objects
    }

}
