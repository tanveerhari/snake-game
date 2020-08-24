package game.snake;

import game.board.Board;
import game.board.Point;


public class Snake
{

	public enum Direction
	{
		LEFT, RIGHT, UP, DOWN
	}
	
	private Point headPoint;
	
	private SnakePointsSet set;
	private Direction currentDirection;
	
	public Snake(final Point[] initialPoints)
	{
		this.headPoint = initialPoints[initialPoints.length - 1];
		currentDirection = Direction.LEFT;
		set = new SnakePointsSet(initialPoints);
	}
	
	public void move(Board board) throws ArrayIndexOutOfBoundsException
	{	
		System.out.println(headPoint.getX() + "," + headPoint.getY());
		headPoint = board.getAdajacentPoint(headPoint, currentDirection);
	}
	
	public void changeDirection(boolean isLeftTurn)
	{
		if (currentDirection.equals(Direction.UP)
				|| currentDirection.equals(Direction.DOWN))
		{
			currentDirection = (isLeftTurn) ? Direction.LEFT : Direction.RIGHT;
		} 
		else
		{
			currentDirection = (isLeftTurn) ? Direction.DOWN : Direction.UP;
		}
	}
	
	public Point getHead() {
		return headPoint;
	}

	public void increaseSize(Point point)
	{
		set.increaseSize(point);
	}

	public boolean updateMove(Point point)
	{
		return set.add(point);
	}

	public SnakePointsSet getSet()
	{
		return set;
	}

}
