package com.concepts.tdd;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class VotingSystemTest {

    VotingSystem votingSystem = null;

    @Before
    public void setUp() {
        votingSystem = new VotingSystem();

        votingSystem.vote("josh");
        votingSystem.vote("amy");
        votingSystem.vote("jhon");
        votingSystem.vote("jhon");
        votingSystem.vote("Kane");
    }

    @Test
    public void testVote() {
        assertEquals(4, votingSystem.getVotes().size());
    }

    @Test
    public void testGetVotes() {
        assertEquals(2, votingSystem.getVotes().get("jhon").intValue());
    }

    @Test
    public void testInsertionOrder(){
        assertEquals("josh", votingSystem.getVotes().keySet().iterator().next());
    }
}