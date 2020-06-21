package com.example.exercise;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Navigator {
    public Area area;

    public Navigator(List<Integer> areaSize, List<Integer> startingPosition, List<List<Integer>> oilPatches) {
        if (areaSize.size() != 2) {
            throw new IllegalArgumentException("Need exactly two values in areaSize.");
        }
        if (startingPosition.size() != 2) {
            throw new IllegalArgumentException("Need exactly two values in startPosition.");
        }
        this.area = new Area(areaSize.get(0), areaSize.get(1), startingPosition.get(0), startingPosition.get(1));

        for (List<Integer> patch : oilPatches) {
            if (patch.size() != 2) {
                throw new IllegalArgumentException("Need exactly two values in all oilPatches.");
            }
            int x = patch.get(0);
            int y = patch.get(1);
            this.area.addOilPatch(this.area.createCoordinates(x, y));
        }
    }

    public int navigate(String instructions) {
        int cleanedPatches = 0;
        for (int i = 0; i < instructions.length(); i++) {
            this.area.move(instructions.charAt(i));
            if (this.area.cleanCurrentPosition()) {
                cleanedPatches += 1;
            }
        }
        return cleanedPatches;
    }

    public List<Integer> getCurrentPosition() {
        List<Integer> position = new ArrayList<Integer>();
        position.add(this.area.currentPosition.x);
        position.add(this.area.currentPosition.y);
        return position;
    }

    // Used as entry point for debugging navigator
    public static void main(String[] args) {
        List<Integer> areaSize = new ArrayList<Integer>(Arrays.asList(5, 5));
        List<Integer> startingPosition = new ArrayList<Integer>(Arrays.asList(1, 2));
        List<List<Integer>> oilPatches = new ArrayList<List<Integer>>(
                Arrays.asList(new ArrayList<Integer>(Arrays.asList(1, 0)), new ArrayList<Integer>(Arrays.asList(2, 2)),
                        new ArrayList<Integer>(Arrays.asList(2, 3))));
        String instructions = "NNESEESWNWW";

        Navigator exercise = new Navigator(areaSize, startingPosition, oilPatches);
        int cleaned = exercise.navigate(instructions);

        List<Integer> finalPosition = exercise.getCurrentPosition();
        System.out.println(cleaned);
        System.out.println(finalPosition);
    }
}