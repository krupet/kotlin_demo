package com.krupet.hackerrank;

import java.util.Comparator;

class Player{

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String name;
    public int score;
}

public class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        if (a.score > b.score) return - 1;
        if (a.score < b.score) return 1;
        return a.name.compareTo(b.name);
    }
}
