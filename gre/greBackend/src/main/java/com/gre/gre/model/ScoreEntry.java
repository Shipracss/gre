package com.gre.gre.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScoreEntry {
    private String date;
    private int verbal;
    private int quant;
}
