package com.codenjoy.dojo.snake.client;

import com.codenjoy.dojo.client.*;
import com.codenjoy.dojo.services.Point;
import com.codenjoy.dojo.snake.model.Elements;

import java.util.*;

/**
 * User: oleksandr.baglai
 * Date: 10/2/12
 * Time: 12:07 AM
 */
public class Board extends AbstractBoard<Elements> {

    @Override
    public Elements valueOf(char ch) {
        return Elements.valueOf(ch);
    }

    public List<Point> getApples() {
        return this.get(Elements.GOOD_APPLE);
    }

    public Direction getSnakeDirection() {
        Point head = this.getHead();
        if (this.isAt(head.getX(), head.getY(), Elements.HEAD_LEFT)) {
            return Direction.LEFT;
        } else if (this.isAt(head.getX(), head.getY(), Elements.HEAD_RIGHT)) {
            return Direction.RIGHT;
        } else if (this.isAt(head.getX(), head.getY(), Elements.HEAD_UP)) {
            return Direction.UP;
        } else {
            return Direction.DOWN;
        }
    }

    public Point getHead() {
        List<Point> result = this.get(
                Elements.HEAD_UP,
                Elements.HEAD_DOWN,
                Elements.HEAD_LEFT,
                Elements.HEAD_RIGHT);
        return result.get(0);
    }

    public List<Point> getBarriers() {
        List<Point> result = this.getSnake();
        result.addAll(this.getStones());
        result.addAll(this.getWalls());
        return result;
    }

    public List<Point> getSnake() {
        List<Point> result = this.get(
                Elements.TAIL_END_DOWN,
                Elements.TAIL_END_LEFT,
                Elements.TAIL_END_UP,
                Elements.TAIL_END_RIGHT,
                Elements.TAIL_HORIZONTAL,
                Elements.TAIL_VERTICAL,
                Elements.TAIL_LEFT_DOWN,
                Elements.TAIL_LEFT_UP,
                Elements.TAIL_RIGHT_DOWN,
                Elements.TAIL_RIGHT_UP);
        result.add(0, this.getHead());
        return result;
    }

    @Override
    public String toString() {
        return String.format("Board:\n%s\n" +
            "Apple at: %s\n" +
            "Stones at: %s\n" +
            "Head at: %s\n" +
            "Snake at: %s\n" +
            "Current direction: %s",
                this.boardAsString(),
                this.getApples(),
                this.getStones(),
                this.getHead(),
                this.getSnake(),
                this.getSnakeDirection());
    }

    public List<Point> getStones() {
        return this.get(Elements.BAD_APPLE);
    }

    public List<Point> getWalls() {
        return this.get(Elements.BREAK);
    }

    public boolean isTailOn(Point from, Direction direction) {
        List<Point> snake = getSnake();
        Point point = direction.change(from);
        return snake.contains(point);
    }
}