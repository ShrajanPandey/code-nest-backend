package com.nincompoop.codenest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * Created by Shrajan
 * Wednesday 04-09-2024
 * 01:09
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchFilter {

    @Nullable
    List<String> difficulty;
    @Nullable
    List<String> concepts;
    @Nullable
    List<String> companies;
    boolean sortByAccepted;
    boolean sortByDifficulty;

}
