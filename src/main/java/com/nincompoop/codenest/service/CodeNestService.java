package com.nincompoop.codenest.service;

import com.nincompoop.codenest.dtos.ProblemDetails;
import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.SearchFilter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:03
 */

public interface CodeNestService {

    List<ProblemListDTO> fetchProblemsList(@NonNull int offset, @NonNull int limit, @Nullable SearchFilter searchFilter);

    ProblemDetails loadProblemDetails(@NonNull String problemId);

}
