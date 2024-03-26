package com.concepts.tdd;

import java.util.LinkedHashMap;

public class VotingSystem {

    private LinkedHashMap<String, Integer> votingMap = null;

    public VotingSystem() {
        votingMap = new LinkedHashMap<>();
    }

    void vote(String participant) {
        votingMap.put(participant, votingMap.getOrDefault(participant, 0) + 1);
    }

    public LinkedHashMap<String, Integer> getVotes() {
        return votingMap;
    }
}
