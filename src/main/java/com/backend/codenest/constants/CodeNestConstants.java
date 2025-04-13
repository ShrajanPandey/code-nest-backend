package com.backend.codenest.constants;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:27
 */

public class CodeNestConstants {

    public static final String SUCCESS = "Success";
    public static final String ERROR = "Error";
    public static final String SUCCESS_CODE = "200";
    public static final String ERROR_CODE = "500";

    public enum ACTION {
        SUBMIT, RUN
    }

    public enum RUN_STATUS {
        CORRECT, INCORRECT_ANSWER
    };

    public enum SUBMIT_STATUS {
        ACCEPTED, PARTIALLY_ACCEPTED, FAILED
    }


}
