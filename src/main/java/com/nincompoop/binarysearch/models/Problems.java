package com.nincompoop.binarysearch.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Created by Shrajan
 * -- Wednesday 04-09-2024
 * -- 00:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "problems")
public class Problems {

    @Id
    int id;
    String problemName;
    String submissions;
    String accepted;
    LocalDate dateCreated;

}
