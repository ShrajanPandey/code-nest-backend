package com.nincompoop.binarysearch.service;

import com.nincompoop.binarysearch.dtos.ProblemListDTO;
import com.nincompoop.binarysearch.dtos.SearchFilter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:03
 */

public interface BinarySearchService {

    List<ProblemListDTO> getProblemsList(@NonNull int offset, @NonNull int limit, @Nullable SearchFilter searchFilter);

}
