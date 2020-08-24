package game.food;

import game.board.Board;
import game.board.Point;
import game.snake.SnakePointsSet;

public class FoodGenerator {
	private final Board board;

	public FoodGenerator(final Board board) {
		this.board = board;
	}

	public Point generateNextPoint(Point currentPoint, SnakePointsSet set) {
		Point nextPoint = null;

		do {
			int x = getRandomNumberInRange(0, getBoard().getRows() - 1);
			int y = getRandomNumberInRange(0, getBoard().getCols() - 1);

			nextPoint = getBoard().get(x, y);

		} while (currentPoint.equals(nextPoint) || set.contains(nextPoint));

		return nextPoint;
	}

	private int getRandomNumberInRange(int min, int max) {
		return min + (int) (Math.random() * (max - min + 1));
	}

	public Board getBoard() {
		return board;
	}

}
