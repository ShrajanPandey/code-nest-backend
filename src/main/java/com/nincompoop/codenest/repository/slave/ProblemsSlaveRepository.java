package com.nincompoop.codenest.repository.slave;

import com.nincompoop.codenest.models.Problems;
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
public interface ProblemsSlaveRepository extends JpaRepository<Problems, String> {

    @Query(value = "select * FROM Problems LIMIT :limit OFFSET :offset", nativeQuery = true)
    List<Problems> getProblemsList(@Param("offset") int offset,@Param("limit") int limit);

}
