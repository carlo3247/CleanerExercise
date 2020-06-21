package com.example.exercise.json;

import java.util.List;

public class Output {
    private int oilPatchesCleaned;
    private List<Integer> finalPosition;

    public Output(int oilPatchesCleaned, List<Integer> finalPosition) {
        this.oilPatchesCleaned = oilPatchesCleaned;
        this.finalPosition = finalPosition;
    }

    public List<Integer> getFinalPosition() {
        return this.finalPosition;
    }

    public void setFinalPosition(List<Integer> finalPosition) {
        this.finalPosition = finalPosition;
    }

    public int getOilPatchesCleaned() {
        return this.oilPatchesCleaned;
    }

    public void setOilPatchesCleaned(int oilPatchesCleaned) {
        this.oilPatchesCleaned = oilPatchesCleaned;
    }
}