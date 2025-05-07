package com.backend.codenest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * @author - shrajan.pandey
 * Friday 25/04/25
 */

@Builder
@Entity(name = "user_submission")
@NoArgsConstructor
@AllArgsConstructor
public class UserSubmission {

    public enum EvaluationStatus {
        STARTED,
        EXECUTED,
        EVALUATED
    }

    public enum Status {
        AC, WA
    }

    @Id 
    @Column(name = "id")
    int id;

    @Column(name = "user_id")
    String userId;

    @Column(name = "evaluation_status")
    @Enumerated(EnumType.STRING)
    EvaluationStatus evaluationStatus;



}