package game.board;

import game.snake.Snake.Direction;

public class Board
{
	private final int rows;
	private final int cols;
	private final Point[][] array;

	public Board(final int rows, final int cols)
	{
		this.rows = rows;
		this.cols = cols;

		array = new Point[rows][cols];
		populateArray();
	}

	private void populateArray()
	{
		for (int i = 0; i < getRows(); i++)
		{
			for (int j = 0; j < getCols(); j++)
			{
				put(i, j);
			}
		}

	}

	public int getRows()
	{
		return rows;
	}

	public int getCols()
	{
		return cols;
	}
	
	private void put(int x, int y)
	{
		array[x][y] = new Point(x, y);
	}

	public Point get(int x, int y)
	{
		return array[x][y];
	}

	public Point getAdajacentPoint(Point point, Direction direction) throws ArrayIndexOutOfBoundsException
	{
		switch(direction)
		{
		case DOWN:
			return get(point.getX(), point.getY() + 1);
		case LEFT:
			return get(point.getX() - 1, point.getY());
		case RIGHT:
			return get(point.getX() + 1, point.getY());
		case UP:
			return get(point.getX(), point.getY() - 1);
		default:
			break;
		
		}
		// throwing array index out of bounds exception
		return get(-1, -1);
	}
	
}
