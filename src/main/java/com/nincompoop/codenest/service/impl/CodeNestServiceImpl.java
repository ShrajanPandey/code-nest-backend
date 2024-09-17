package com.nincompoop.codenest.service.impl;

import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.dtos.SearchFilter;
import com.nincompoop.codenest.service.CodeNestService;
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
public class CodeNestServiceImpl implements CodeNestService {

    @Override
    public List<ProblemListDTO> getProblemsList(@NonNull int offset, @NonNull int limit, @Nullable SearchFilter searchFilter) {
        return List.of();
    }

}
