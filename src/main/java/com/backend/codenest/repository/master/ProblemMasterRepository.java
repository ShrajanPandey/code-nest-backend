package com.backend.codenest.repository.master;

import com.backend.codenest.entities.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author - shrajan.pandey
 * 18 18/09/24 09 2024
 */

@Repository
public interface ProblemMasterRepository extends JpaRepository<Problem, String> {

}
