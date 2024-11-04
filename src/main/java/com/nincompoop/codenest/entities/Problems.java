package com.nincompoop.codenest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:31
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problems")
public class Problems {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "problem_name")
    String problemName;

    @Column(name = "problem_statement_path")
    String problemStatementPath;

    @Column(name = "sample_testcases_path")
    String sampleTestCasesPath;

    @Column(name = "submission_count")
    int submissionCount;

    @Column(name = "accepted_count")
    int acceptedCount;

    @Column(name = "difficulty")
    String difficulty;

    @Column(name = "hidden_testcases_path")
    String hiddenTestCasesPath;

    @Column(name = "author")
    String author;

    @Column(name = "date_modified")
    LocalDateTime dateModified;

    @Column(name = "date_created")
    LocalDate dateCreated;

    @Column(name = "concept_tags")
    String conceptTags;

    @Column(name = "companies")
    String companies;

    @Column(name = "row_version")
    int rowVersion;

}
