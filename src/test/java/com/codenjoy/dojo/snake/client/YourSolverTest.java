package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.RandomDice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YourSolverTest {
    @Test
    public void TestSameDirection(){

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ▼  ☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼☼☼☼☼☼\n", "DOWN");

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼► ☺ ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "RIGHT");

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼    ☼\n" +
                "☼ ▲  ☼\n" +
                "☼☼☼☼☼☼\n", "UP");

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼☺  ◄☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "LEFT");
    }

    @Test
    public void TestNotSameDirection(){

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ►  ☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼☼☼☼☼☼\n", "DOWN");

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼▼ ☺ ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "RIGHT");

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼    ☼\n" +
                "☼ ►  ☼\n" +
                "☼☼☼☼☼☼\n", "UP");

        assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼☺  ►☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "LEFT");
    }

    private void assertB(String boardString, String expected) {
        //given
        YourSolver solver = new YourSolver(new RandomDice());

        //when
        String direction = solver.get((Board)new Board().forString(
                boardString));

        //then
        assertEquals(expected, direction);
    }


}
