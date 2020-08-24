package game.board;

public class Point
{
	private final int x;
	private final int y;
	
	protected Point(final int x, final int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}
	
	@Override
	public int hashCode()
	{
		int result = x;
	    result = 31 * result + y;
	    
	    return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		Point point = (Point) obj;
		
		return (this.getX() == point.getX() && this.getY() == point.getY());
	}
}
