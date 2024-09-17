package com.nincompoop.codenest.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 00:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problems")
public class Problems {

    @Id
    int id;
    String problemName;
    String problemStatement;
    SampleTestCase sampleTestCases;
    int submissions;
    int accepted;
    String tesCasesPath;
    String author;
    LocalDate dateModified;
    LocalDate dateCreated;
    List<String> concepts;
    List<String> companies;

    @Data
    static class SampleTestCase {
        String input;
        String output;
        String explanation;
    }

}
