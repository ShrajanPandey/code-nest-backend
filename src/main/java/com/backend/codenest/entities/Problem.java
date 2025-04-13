package com.backend.codenest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:31
 */

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problem")
public class Problem {

    @Id
    @Column(name = "id")
    String id;

    @Column(name = "problem_name")
    String problemName;

    @Column(name = "problem_statement")
    String problemStatement;

    @Column(name = "sample_testcases")
    String sampleTestCases;

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

    @Column(name = "concept_tags")
    String conceptTags;

    @Column(name = "companies")
    String companies;

    @Column(name = "row_version")
    int rowVersion;

    @Column(name = "date_modified")
    LocalDateTime dateModified;

    @Column(name = "date_created")
    LocalDate dateCreated;


}
