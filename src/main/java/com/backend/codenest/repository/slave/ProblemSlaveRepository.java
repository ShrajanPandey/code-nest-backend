package com.backend.codenest.repository.slave;

import com.backend.codenest.entities.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author - shrajan.pandey
 * 18 18/09/24 09 2024
 */

@Repository
public interface ProblemSlaveRepository extends JpaRepository<Problem, String> {

    @Query(value = "select * FROM Problem LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Problem> getProblemsList(@Param("offset") int offset, @Param("limit") int limit);

}
