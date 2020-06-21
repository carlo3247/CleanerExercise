package com.example.exercise;

import java.util.HashSet;

public class Area {
    private Coordinates bounds;
    private HashSet<Coordinates> oilPatches;
    public Coordinates currentPosition;

    public Area(int boundsX, int boundsY, int currentPositionX, int currentPositionY) {
        if (boundsX < 1 || boundsY < 1) {
            throw new IllegalArgumentException("Area size bounds have to be positive integers.");
        }
        this.bounds = new Coordinates(boundsX, boundsY);
        this.currentPosition = createCoordinates(currentPositionX, currentPositionY);
        this.oilPatches = new HashSet<>();
    }

    public void move(char direction) {
        switch (direction) {
            case 'N':
                this.currentPosition.y += 1;
                break;
            case 'E':
                this.currentPosition.x += 1;
                break;
            case 'S':
                this.currentPosition.y -= 1;
                break;
            case 'W':
                this.currentPosition.x -= 1;
                break;
            default:
                throw new IllegalArgumentException("Illegal navigation instruction encountered.");
        }
        if ((this.currentPosition.x < 0 || this.currentPosition.x > this.bounds.x)
                || (this.currentPosition.y < 0 || this.currentPosition.y > this.bounds.y)) {
            throw new IllegalStateException("Navigated out of bounds.");
        }
    }

    // returns True if oil patch is cleaned, False otherwise
    public Boolean cleanCurrentPosition() {
        return this.oilPatches.remove(this.currentPosition);
    }

    public void addOilPatch(Coordinates position) {
        this.oilPatches.add(position);
    }

    public Coordinates createCoordinates(int x, int y) {
        if ((x < 0 || x > this.bounds.x) || (y < 0 || y > this.bounds.y)) {
            throw new IllegalArgumentException("Coordinates out of bounds.");
        }
        return new Coordinates(x, y);
    }

    public static class Coordinates {
        public int x;
        public int y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // https://stackoverflow.com/questions/27581/what-issues-should-be-considered-when-overriding-equals-and-hashcode-in-java
        // https://stackoverflow.com/questions/3692426/hashset-does-not-seem-to-realize-that-two-objects-are-the-same
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Coordinates other = (Coordinates) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }
}