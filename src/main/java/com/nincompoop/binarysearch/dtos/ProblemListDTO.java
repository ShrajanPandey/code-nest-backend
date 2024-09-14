package com.nincompoop.binarysearch.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:09
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemListDTO {

    @NonNull
    String problemId;
    @NonNull
    String problemName;
    @NonNull
    String difficulty;
    @Nullable
    int submission;
    @Nullable
    int accepted;

}
