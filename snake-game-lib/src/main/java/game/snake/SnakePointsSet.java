package game.snake;

import java.util.LinkedHashSet;

import game.board.Point;

public class SnakePointsSet
{

	private LinkedHashSet<Point> pointSet = new LinkedHashSet<Point>(); 

	private int size = 0;
	private Point lastPoint;
	
	public SnakePointsSet(Point[] initialPoints)
	{
		for(Point point : initialPoints)
		{
			pointSet.add(point);
		}
		
		size = initialPoints.length;
		lastPoint = initialPoints[0];
		System.out.println("last point:" + lastPoint.getX() + "," + lastPoint.getY());
	}
	
	public boolean add(Point point)
	{
		if(contains(point))
		{
			return false;
		}
		//add point to set
		boolean isAdded = pointSet.add(point);
		
		//remove last point
		pointSet.remove(lastPoint);
		
		//update last point		
		lastPoint = (Point) pointSet.toArray()[0];
		System.out.println("last point:" + lastPoint.getX() + "," + lastPoint.getY());
		return isAdded;
	}
	
	public boolean contains(Point point)
	{
		return pointSet.contains(point);
	}
	
	//TODO: Fix possible memory leak, as every time a new array object is created.
	public Point[] getPoints()
	{
		return pointSet.toArray(new Point[size]);
	}
	
	public int getSize()
	{
		return size;
	}

	public void increaseSize(Point point)
	{
		size++;
		
		if(!contains(point))
		{
			pointSet.add(point);
		}
		
	}

}
