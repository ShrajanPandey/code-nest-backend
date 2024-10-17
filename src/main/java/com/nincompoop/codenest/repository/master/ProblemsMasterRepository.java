package com.nincompoop.codenest.repository.master;

import com.nincompoop.codenest.models.Problems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - shrajan.pandey
 * 18 18/09/24 09 2024
 */

@Repository
public interface ProblemsMasterRepository extends JpaRepository<Problems, String> {

}
