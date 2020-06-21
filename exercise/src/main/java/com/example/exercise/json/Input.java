package com.example.exercise.json;

import java.util.List;

public class Input {
    private List<Integer> areaSize;
    private List<Integer> startingPosition;
    private List<List<Integer>> oilPatches;
    private String navigationInstructions;

    public List<Integer> getAreaSize() {
        return this.areaSize;
    }

    public void setAreaSize(List<Integer> areaSize) {
        this.areaSize = areaSize;
    }

    public List<Integer> getStartingPosition() {
        return this.startingPosition;
    }

    public void setStartingPosition(List<Integer> startPosition) {
        this.startingPosition = startPosition;
    }

    public List<List<Integer>> getOilPatches() {
        return this.oilPatches;
    }

    public void setOilPatches(List<List<Integer>> oilPatches) {
        this.oilPatches = oilPatches;
    }

    public String getNavigationInstructions() {
        return this.navigationInstructions;
    }

    public void setNavigationInstructions(String navigationInstructions) {
        this.navigationInstructions = navigationInstructions;
    }
}