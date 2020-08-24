package game;

import game.board.Board;
import game.board.Point;
import game.food.FoodGenerator;
import game.snake.Snake;
import game.snake.Snake.Direction;

public class GameManager
{
	public static Game setupGame(final int boardRows, final int boardCols)
	{
		Board board = new Board(boardRows, boardCols);
		
		Snake snake = buildSnake(board);
		
		FoodGenerator foodGenerator = new FoodGenerator(board);
		
		Game game = new Game(snake, foodGenerator, board);
		
		return game;
	}
	
	public static int playGame(final Game game, final GameUI gameUI) throws InterruptedException 
	{
		while (game.isInPlay()) 
		{
			game.playNextMove();
			gameUI.refreshUI();
			Thread.sleep(100);
		}
		System.out.println("game over");
		
		return game.getScore();
	}

	private static Snake buildSnake(final Board board)
	{
		Point[] initialPoints = new Point[3];
		
		int initialX = board.getRows() / 2;
		int initialY = board.getCols() / 2;
		
		initialPoints[0] = board.get(initialX, initialY);
		
		for (int i = 1; i < initialPoints.length; i++)
		{
			initialPoints[i] = board.getAdajacentPoint(initialPoints[i - 1],
					Direction.LEFT);
		}
		
		Snake snake = new Snake(initialPoints);
		
		return snake;
	}

}
