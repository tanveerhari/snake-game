package game.food;

import game.board.Point;


public class Food
{

	private Point point;
	
	public Food(final Point initialPoint)
	{
		this.point = initialPoint;
	}
	
	public void setPoint(final Point nextPoint)
	{
		this.point = nextPoint;
	}
	
	public Point getPoint()
	{
		return point;
	}

}
