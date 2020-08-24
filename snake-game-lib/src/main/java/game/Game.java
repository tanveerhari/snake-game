package game;

import game.board.Board;
import game.board.Point;
import game.food.Food;
import game.food.FoodGenerator;
import game.snake.Snake;

public class Game {

	private int score;
	private boolean isInPlay;

	private final Snake snake;
	private final Food food;
	private final FoodGenerator foodGenerator;
	private final Board board;

	public Game(final Snake snake, final FoodGenerator foodGenerator, Board board) {
		isInPlay = true;
		this.snake = snake;
		this.foodGenerator = foodGenerator;
		this.food = new Food(getFoodGenerator().generateNextPoint(board.get(0, 0), snake.getSet()));
		this.board = board;
	}

	public void playNextMove() {
		try {
			getSnake().move(getBoard());

			if (isFoodGoingToBeEaten(getSnake().getHead())) {
				foodGetsEaten(getSnake().getHead());
			} else {
				isInPlay = getSnake().updateMove(getSnake().getHead());
				System.out.println("Snake eat itself: " + !isInPlay());
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("array index out of bounds");
			isInPlay = false;
		}
	}

	public boolean isInPlay() {
		return isInPlay;
	}

	public int getScore() {
		return score;
	}

	private void foodGetsEaten(Point point) {
		getSnake().increaseSize(point);
		getFood().setPoint(getFoodGenerator().generateNextPoint(getFood().getPoint(), getSnake().getSet()));
		incrementScore();
	}

	private void incrementScore() {
		score += 10;
	}

	private boolean isFoodGoingToBeEaten(Point point) {
		return point.equals(getFood().getPoint());
	}

	public Board getBoard() {
		return board;
	}

	public Snake getSnake() {
		return snake;
	}

	public Food getFood() {
		return food;
	}

	public FoodGenerator getFoodGenerator() {
		return foodGenerator;
	}
}
