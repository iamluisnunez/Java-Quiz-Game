package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class jServiceDTO {
    private List<Clues> clues;

    public List<Clues> getClues() {
        return clues;
    }
    public void setClues(List<Clues> clues) {
        this.clues = clues;
    }

}
