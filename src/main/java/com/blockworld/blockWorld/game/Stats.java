package com.blockworld.blockWorld.game;

public class Stats {
    private int vigor;

    private int level;
    private int currentLevelPoints;

    private int mind;
    private int currentMindPoints;

    private int intelligence;

    private int strength;

    private int dexterity;

    public Stats(int vigor, int level, int currentLevelPoints, int mind, int currentMindPoints, int intelligence, int strength, int dexterity) {
        this.vigor = vigor;
        this.level = level;
        this.currentLevelPoints = currentLevelPoints;
        this.mind = mind;
        this.currentMindPoints = currentMindPoints;
        this.intelligence = intelligence;
        this.strength = strength;
        this.dexterity = dexterity;
    }

    public static Stats createDefault() {
        return new Stats(
                20,
                1,
                0,
                20,
                0,
                10,
                10,
                10
        );
    }
}
