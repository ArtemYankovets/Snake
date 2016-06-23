package com.codenjoy.dojo.snake.client;


import com.codenjoy.dojo.client.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.RandomDice;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private static final String USER_NAME = "artemyankovets@gmail.com";

    private Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;

        Point apple = board.getApples().get(0);
        Point snake_head = board.getHead();

        int dx = snake_head.getX() - apple.getX();
        int dy = snake_head.getY() - apple.getY();

        String direction = Direction.UP.toString();

        if (dx < 0) {
            direction = Direction.RIGHT.toString();
        }

        if (dx > 0) {
            direction = Direction.LEFT.toString();
        }

        if (dy < 0) {
            direction = Direction.DOWN.toString();
        }

        if (dy > 0) {
            direction = Direction.UP.toString();
        }

        return direction;
    }

    public static void main(String[] args) {
        start(USER_NAME, WebSocketRunner.Host.REMOTE);
    }

    public static void start(String name, WebSocketRunner.Host server) {
        try {
            WebSocketRunner.run(server, name,
                    new YourSolver(new RandomDice()),
                    new Board());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
