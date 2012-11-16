package shadow.mods.metallurgy.storage;

public class CoordinateIter 
{
	private final Coordinate start;
	private final Coordinate end;
	private Coordinate curr;
	
	public static CoordinateIter get3x3Iter(Coordinate c)
	{
		return new CoordinateIter(new Coordinate(c.x - 1, c.y - 1, c.z - 1), new Coordinate(c.x + 1, c.y + 1, c.z + 1));
	}
	
	public CoordinateIter(Coordinate c1, Coordinate c2)
	{
		this.start = new Coordinate();
		this.end = new Coordinate();
		
		if(c1.x > c2.x)
		{
			start.x = c2.x;
			end.x = c1.x;
		} else {
			start.x = c1.x;
			end.x = c2.x;
		}
		
		if(c1.y > c2.y)
		{
			start.y = c2.y;
			end.y = c1.y;
		} else {
			start.y = c1.y;
			end.y = c2.y;
		}
		
		if(c1.z > c2.z)
		{
			start.z = c2.z;
			end.z = c1.z;
		} else {
			start.z = c1.z;
			end.z = c2.z;
		}
		
		this.curr = this.start.copy();
	}
	
	public boolean hasNext()
	{
		return curr != null;
	}
	
	public Coordinate next()
	{
		Coordinate ret = curr.copy();
		if(curr == null)
			return null;
		
		curr.x++;
		if(curr.x > end.x)
		{
			curr.x = start.x;
			curr.z++;
			if(curr.z > end.z)
			{
				curr.z = start.z;
				curr.y++;
				if(curr.y > end.y)
					curr = null;
			}
		}
		
		return ret;
	}
}
