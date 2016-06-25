package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.services.RandomDice;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class YourSolverTest {
    @Test
    public void TestSameDirection(){

        this.assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ▼  ☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼☼☼☼☼☼\n", "DOWN");

        this.assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼► ☺ ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "RIGHT");

        this.assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼    ☼\n" +
                "☼ ▲  ☼\n" +
                "☼☼☼☼☼☼\n", "UP");

        this.assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼☺  ◄☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "LEFT");
    }

    @Test
    public void TestNotSameDirection(){

        this.assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ►  ☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼☼☼☼☼☼\n", "DOWN");

        this.assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼▼ ☺ ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "RIGHT");

        this.assertB("☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼    ☼\n" +
                "☼ ►  ☼\n" +
                "☼☼☼☼☼☼\n", "UP");

        this.assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼☺  ►☼\n" +
                "☼    ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "LEFT");
    }

    @Test
    public void testEatMe_LEFT_DOWN_1(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼╘═► ☼\n" +
                "☼ ☺  ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "DOWN");
    }

    @Test
    public void testEatMe_LEFT_DOWN_2(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼  ▲ ☼\n" +
                "☼ ☺║ ☼\n" +
                "☼  ╙ ☼\n" +
                "☼☼☼☼☼☼\n", "LEFT");
    }

    @Test
    public void testEatMe_LEFT_UP_1(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼╘═► ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "UP");
    }

    @Test
    public void testEatMe_LEFT_UP_2(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼  ╓ ☼\n" +
                "☼ ☺║ ☼\n" +
                "☼  ▼ ☼\n" +
                "☼☼☼☼☼☼\n", "LEFT");
    }

    @Test
    public void testEatMe_RIGHT_DOWN_1(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼◄═╕ ☼\n" +
                "☼ ☺  ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "DOWN");
    }

    @Test
    public void testEatMe_RIGHT_DOWN_2(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ▲  ☼\n" +
                "☼ ║☺ ☼\n" +
                "☼ ╙  ☼\n" +
                "☼☼☼☼☼☼\n", "RIGHT");
    }

    @Test
    public void testEatMe_RIGHT_UP_1(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ☺  ☼\n" +
                "☼◄═╕ ☼\n" +
                "☼    ☼\n" +
                "☼☼☼☼☼☼\n", "UP");
    }

    @Test
    public void testEatMe_RIGHT_UP_2(){
        assertB(
                "☼☼☼☼☼☼\n" +
                "☼    ☼\n" +
                "☼ ╓  ☼\n" +
                "☼ ║☺ ☼\n" +
                "☼ ▼  ☼\n" +
                "☼☼☼☼☼☼\n", "RIGHT");
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
