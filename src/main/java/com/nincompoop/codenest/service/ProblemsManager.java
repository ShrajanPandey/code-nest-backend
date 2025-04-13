package com.nincompoop.codenest.service;

import com.nincompoop.codenest.dtos.ProblemListDTO;
import com.nincompoop.codenest.repository.slave.ProblemSlaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author - shrajan.pandey
 * Sunday 13/10/24
 */

@Component
public class ProblemsManager {

    @Autowired
    ProblemSlaveRepository problemSlaveRepository;

    List<ProblemListDTO> getProblemList(){

//        problemsSlaveRepository.getProblemsList(1, 1);
        return List.of();

    }

}
