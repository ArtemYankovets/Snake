package com.codenjoy.dojo.snake.client;


import com.codenjoy.dojo.client.Direction;
import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Dice;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.services.RandomDice;

import java.util.LinkedList;
import java.util.List;

/**
 * User: your name
 */
public class YourSolver implements Solver<Board> {

    private static final String USER_NAME = "artemyankovets@gmail.com";

    private final Dice dice;
    private Board board;

    public YourSolver(Dice dice) {
        this.dice = dice;
    }

    @Override
    public String get(Board board) {
        this.board = board;
        Point apple = board.getApples().get(0);
        Point head = board.getHead();

        return getDirection(head, apple).toString();
    }

    private Direction getDirection(Point head, Point apple) {
        int dx = head.getX() - apple.getX();
        int dy = head.getY() - apple.getY();

        LinkedList<Direction> directions = getDirections(dx, dy);

        Direction direction = directions.getFirst();
        if (directions.size() == 2) {
            if (board.isTailOn(head, direction)) {
                // то выбрать второй вариант
                direction = directions.getLast();
            }
        }

        return direction;
    }

    private LinkedList<Direction> getDirections(int dx, int dy) {
        List<Direction> result = new LinkedList<>();
        if (dx < 0) {
            result.add(Direction.RIGHT);
        }
        if (dx > 0) {
            result.add(Direction.LEFT);
        }
        if (dy < 0) {
            result.add(Direction.DOWN);
        }
        if (dy > 0) {
            result.add(Direction.UP);
        }
        return (LinkedList<Direction>) result;
    }

    public static void main(String[] args) {
        YourSolver.start(YourSolver.USER_NAME, WebSocketRunner.Host.REMOTE);
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
