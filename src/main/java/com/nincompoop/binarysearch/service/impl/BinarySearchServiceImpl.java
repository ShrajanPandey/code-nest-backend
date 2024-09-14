package com.nincompoop.binarysearch.service.impl;

import com.nincompoop.binarysearch.dtos.ProblemListDTO;
import com.nincompoop.binarysearch.dtos.SearchFilter;
import com.nincompoop.binarysearch.service.BinarySearchService;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Shrajan
 * Saturday 14-09-2024
 * 16:03
 */

@Service
public class BinarySearchServiceImpl implements BinarySearchService {

    @Override
    public List<ProblemListDTO> getProblemsList(@NonNull int offset, @NonNull int limit, @Nullable SearchFilter searchFilter) {
        return List.of();
    }

}
